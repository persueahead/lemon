package com.bjlemon.sys.finance.controller.salary;

import com.bjlemon.pojo.Users;
import com.bjlemon.sys.system.service.IUsersService;
import com.bjlemon.sys.system.service.impl.UsersServiceImp;
import com.my.web.servlet.RequestBeanUtils;
import net.sf.json.JSONObject;
import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet( "/finance/salaryQuery")
public class SetSalaryServlet extends HttpServlet {
    IUsersService iUsersService=new UsersServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 //        接收usersId
        Users usersParameter= RequestBeanUtils.requestToBean(request,Users.class);
        System.out.println(usersParameter);
        try {
            Users users1= iUsersService.selectListUsers(usersParameter).get(0);
            Float usersSalary=users1.getUsersSalary();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("usersSalary",usersSalary);
            PrintWriter writer=response.getWriter();
            writer.println(jsonObject);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
