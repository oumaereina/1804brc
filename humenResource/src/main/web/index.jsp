<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/19
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>游客</title>
</head>
<body>
<form action="visitor/visitorLogin" method="post">
    账号：<input name="v_name"><br>
    密码：<input name="v_pass" type="password"><br>
    <input type="submit" value="登录">
</form>
<a href="pages/visitorRegister.jsp">游客注册</a>
</body>
</html>
