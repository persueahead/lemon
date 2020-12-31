package com.bjlemon.sys.system.controller.cost;

import com.bjlemon.pojo.Cost;
import com.bjlemon.sys.system.dao.ICostDao;
import com.bjlemon.sys.system.dao.imp.CostsDaoImp;
import com.bjlemon.sys.system.service.IcostService;
import com.bjlemon.sys.system.service.impl.CostServiceImp;
import com.bjlemon.utiles.ThisAssertion;
import com.my.web.servlet.RequestBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/system/CostUpdateServlet")
public class CostUpdateServlet extends HttpServlet {
    IcostService icostService=new CostServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  点击保存时是form表单post方式提交
//        从客户端接收更改信息 此时从jsp能得到的属性信息是除costMark的全部
        Cost cost=RequestBeanUtils.requestToBean(request,Cost.class);
        try{
 //        在数据库进行同步更改
            int result=icostService.updateCost(cost);
            ThisAssertion.isNotNumberNull("更新信息失败",result);
//            保存更改的信息 转发到jsp继续显示
            request.setAttribute("cost",cost);
            request.setAttribute("tip","修改信息成功");
            request.getRequestDispatcher("/view/system/cost/cost_update.jsp").forward(request,response);
        }catch(Exception e){
            request.setAttribute("tip","费用信息更新失败");
            request.getRequestDispatcher("/view/system/cost/cost_update.jsp").forward(request,response);
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  点击修改 是get跳转 仅带有参数costId
//        包装成成cost bean对象
        Cost cost= RequestBeanUtils.requestToBean(request,Cost.class);

        try {
//        通过costId查询该cost的全部信息     id有值，作为查询条件，因此查询出来的只有一个costBean
            List<Cost> list=icostService.selectCostList(cost);
//            取第一个 也是唯一一个
            Cost costList=list.get(0);
//            显示取出来的那个的信息 先设置属性 再传入jsp进行显示
            request.setAttribute("cost",costList);
            request.getRequestDispatcher("/view/system/cost/cost_update.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
