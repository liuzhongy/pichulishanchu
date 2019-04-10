package com.bjpowernode.contoller;

import com.bjpowernode.model.Emp;
import com.bjpowernode.util.RequestUtil;
import com.bjpowernode.util.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Emp emp =null;
            //1.读取浏览器发送的【请求协议包信息】
            emp = (Emp)RequestUtil.init(request, Emp.class);
            //2.JDBC来完成插入操作
        try {
            SqlSession.insert(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
