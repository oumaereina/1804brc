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
    <table>
        <tr>
            <td> 账号：</td>
            <td><input name="v_name"></td>
            <td></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input name="v_pass" type="password"></td>
            <td></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
        <tr><td><p style="color: crimson">${requestScope.msg}</p></td></tr>
    </table>
</form>
<a href="pages/visitorRegister.jsp">游客注册</a>
</body>
</html>
