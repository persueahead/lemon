package com.bj.springmvc.test;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Component
public class ThisMyView implements View {

    @Override
    public String getContentType() {
        return "text/html;charset=UTF-8";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        httpServletResponse.getWriter().print("HELOO"+new Date());
    }
}
