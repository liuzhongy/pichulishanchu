package com.bjpowernode.contoller;

import com.bjpowernode.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

public class EmpDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String array[]=null;
         String sql="delete from emp where empno=?";
         PreparedStatement ps = null;
        //1.【request】读取【请求协议包参数】empNo=9999&empNo=8888
        array=request.getParameterValues("empNo");//[9999,8888]
        //2.JDBC实现批处理删除
        ps = DBUtil.createStatement(sql);
        try {
            for(String empNo:array){
                ps.setString(1, empNo);//mySql支持类型默认转换---》索引失效
                ps.addBatch();
            }
            ps.executeBatch();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally
        {
              DBUtil.close(null);
        }


    }//Tomcat 销毁本次请求相关的request和response
     //Tomcat 负责将【响应包】推送到浏览器上
}
