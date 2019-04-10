package com.bjpowernode.contoller;

import com.bjpowernode.service.DeptService;
import com.bjpowernode.serviceImpl.DeptServiceImpl;
import com.bjpowernode.util.Agent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeptDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptNo = null;
        DeptService service = new DeptServiceImpl();
        DeptService agent = new Agent(service);
        //1.读取请求参数【部门编号】
        deptNo = request.getParameter("deptNo");
        //2.调用service进行部门与职员批处理删除业务
        try {
            agent.deleteDept(deptNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
