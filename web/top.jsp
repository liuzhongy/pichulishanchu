<%@ page import="com.bjpowernode.model.Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28 0028
  Time: 下午 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  Emp emp=(Emp) session.getAttribute("key");
%>
<div align="right">

    <font color="red"> 欢迎<%=emp.getEname()%>登录</font>
</div>
</body>
</html>
