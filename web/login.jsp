<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28 0028
  Time: 下午 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
   String info =(String)request.getAttribute("error");
%>
<body>
           <center>
               <form action="/myWeb/login.do" method="post">

                   用户名:<input type="text" name="ename"><br/><font color="red"><%=info%></font>
                   密&nbsp;码:<input type="text" name="empNo"><br/>
                   <input type="submit" value="登录">
               </form>

           </center>
</body>
</html>
