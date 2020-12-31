package com.bjlemon.sys.system.controller.cost;

import com.bjlemon.pojo.Cost;
import com.bjlemon.sys.system.service.IcostService;
import com.bjlemon.sys.system.service.impl.CostServiceImp;
import com.my.web.servlet.RequestBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/system/CostAddServlet")
public class CostAddServlet extends HttpServlet {
    IcostService icostService=new CostServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    添加页面提交表单 post跳转到servlet
//        接收表单数据
        Cost cost= RequestBeanUtils.requestToBean(request,Cost.class);
        try {
//        在数据库添加数据
            icostService.addCost(cost);
            request.setAttribute("tip","费用信息添加成功");
//            添加页面不变
            request.getRequestDispatcher("/view/system/cost/cost_add.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("tip",e.getMessage());
            request.getRequestDispatcher("/view/system/cost/cost_add.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        action为get跳转 跳转到添加页面
        try{
            request.getRequestDispatcher("/view/system/cost/cost_add.jsp").forward(request,response);
        }catch(Exception e){
            request.getRequestDispatcher("/view/index.jsp").forward(request,response);
            request.setAttribute("tip","请求异常");
            e.printStackTrace();
        }

    }
}
