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
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet("/system/deleteCost")
public class CostDeleteServlet extends HttpServlet {
    IcostService icostService=new CostServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      删除是post方式提交表单
//        获取表单信息
        Cost cost=RequestBeanUtils.requestToBean(request, Cost.class);
//        System.out.println(cost);//Cost{costId=0, costName='', costDesc='null', costMark=null} 成员变量int costId 默认值为0
//        System.out.println("封装后的ids[]:"+ Arrays.toString(cost.getIds()));//eg:封装后的ids[]:[6, 7]
//        执行删除 ——更改Mark状态
        try {
            int result=icostService.deleteCost(cost);
            request.setAttribute("tip","删除成功");
            request.getRequestDispatcher("/system/CostListServlet").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//  删除只是一个功能  不需要提交表单 不用分方式执行servlet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
