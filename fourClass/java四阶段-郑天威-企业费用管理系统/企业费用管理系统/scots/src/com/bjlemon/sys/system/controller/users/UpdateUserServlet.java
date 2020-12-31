package com.bjlemon.sys.system.controller.users;

import com.bjlemon.pojo.Users;
import com.bjlemon.sys.system.service.IUsersService;
import com.bjlemon.sys.system.service.impl.UsersServiceImp;
import com.my.web.servlet.RequestBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/system/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    IUsersService iUsersService = new UsersServiceImp();

    /**
     * doget 和 dopost 功能分开
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    修改页面信息提交 post跳转 完成修改 页面不变
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//              获取对应的查询数据  包含user表全部信息 提交到该处的属性不包含rolename  因为update页面没有rolename属性
//           Users{usersId=2, roleId=1, usersName='jack', usersAge=18, usersPhone='13111000', usersSalary=4000.0,
//                      *usersAccount='jack', usersPwd='jack', usersMark='null', usersSex='女', roleName='null'}
            Users users = RequestBeanUtils.requestToBean(request, Users.class);

//            先更新数据库信息
            iUsersService.updateUsersService(users);
 //           再查询完整信息 ，为了查询出rolename(rolename多选框传到后台时传递的时roleid值 所以接收来的user的username是null)
            List<Users> usersList = iUsersService.selectListUsers(users);
//                取第一个 也是唯一一个 创建user对象
            Users us = usersList.get(0);
//             更新user属性
            request.setAttribute("user", us);
            request.setAttribute("tip", "当前用户修改成功");
            request.getRequestDispatcher("/view/system/user/userinfo_update.jsp").forward(request, response);
        } catch (Exception e) {

            e.printStackTrace();
            request.setAttribute("tip", "当前用户修改失败");
            request.getRequestDispatcher("/view/system/user/userinfo_update.jsp").forward(request, response);
        }


    }

    //        点击修改后 action跳转 为get方式 进入修改页面
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //通过要修改的user的id查询出该user对应的数据
        try {
            //获取对应的查询数据  此bean只有id被赋值 直接在action上抓取的属性
            Users users = RequestBeanUtils.requestToBean(request, Users.class);
//            System.out.println(users);
            //调用条件查询 id有值 查出来其实只有一个 包含了user表全部信息和rolename
            List<Users> usersList = iUsersService.selectListUsers(users);
//                取第一个 也是唯一一个
            Users us = usersList.get(0);
//            System.out.println("*************"+us);
            request.setAttribute("user", us);
//              跳转到修改页面 包含包含了user表全部信息和rolename 但是update页面本身是没有rolename属性的 只是用el表达式接收user.rolenane
            request.getRequestDispatcher("/view/system/user/userinfo_update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
