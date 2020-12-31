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
import java.util.List;

@WebServlet( "/system/CostListServlet")
public class CostQueryListServlet extends HttpServlet {
    IcostService icostService=new CostServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    接收请求的数据，封装成bean对象
        Cost cost= RequestBeanUtils.requestToBean(request,Cost.class);
        try {
//            按接收到的条件查询 查询结果放在list里面
            List<Cost> costList=icostService.selectCostList(cost);
//            保存查询痕迹
            request.setAttribute("cost",cost);
//            显示查询结果
            request.setAttribute("costsList",costList);
 //           跳转jsp页面进行显示
            request.getRequestDispatcher("/view/system/cost/cost_list.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

//            查询所有初始信息 new Cost()属性都是空的所以查询的是全部cost
            List<Cost> costsList=icostService.selectCostList(new Cost());
//            设置属性
            request.setAttribute("costsList",costsList);
//            跳转jsp   获取dispatcher    还要转发
            request.getRequestDispatcher("/view/system/cost/cost_list.jsp").forward(request,response);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
