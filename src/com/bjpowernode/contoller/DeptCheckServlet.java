package com.bjpowernode.contoller;

import com.bjpowernode.dao.DeptDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeptCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String dname = null;
          DeptDao dao = new DeptDao();
          int result=0;
         //1.读取请求协议包参数【部门名称】
          dname = request.getParameter("dname");
         //2.Dao层查询这个部门名称是否已经存在
          result = dao.checkDname(dname);
        //3.将查询结果写入到【响应包】
          response.getWriter().print(result);

    }//Tomcat将【响应包】推送给当前的异步请求对象
}
