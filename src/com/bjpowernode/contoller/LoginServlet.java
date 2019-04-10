package com.bjpowernode.contoller;

import com.bjpowernode.dao.EmpDao;
import com.bjpowernode.model.Emp;
import com.bjpowernode.util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

             //1.读取浏览器发送的请求参数
        Emp emp = (Emp)RequestUtil.init(request, Emp.class);
             //2.调用Dao
        EmpDao dao = new EmpDao();
        emp = dao.login(emp);
        if(emp==null){
            request.setAttribute("error", "用户信息不对");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else{

            HttpSession session = request.getSession();
            session.setAttribute("key", emp);
            response.sendRedirect("/myWeb/index.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
