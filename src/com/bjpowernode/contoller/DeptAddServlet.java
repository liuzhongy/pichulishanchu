package com.bjpowernode.contoller;

import com.bjpowernode.model.Dept;
import com.bjpowernode.util.RequestUtil;
import com.bjpowernode.util.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeptAddServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 Dept dept = null;
                 //1.设置request使用的字符集
                 request.setCharacterEncoding("utf-8");
                //2.【request】读取【请求协议包】中【请求参数信息】
                 dept = (Dept)RequestUtil.init(request, Dept.class);
                //3.【JDBC】得到新部门信息添加到部门表
        try {
            SqlSession.insert(dept);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //4 通过重定向方案，将【DeptFindServlet】地址交给浏览器
                response.sendRedirect("/myWeb/dept/find.do");

    }
}
