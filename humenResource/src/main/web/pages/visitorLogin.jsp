<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/20
  Time: 17:37
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
    <title>游客登录</title>
</head>
<body>
<form action="visitor/visitorLogin" method="post">
    <table>
        <tr><td>您还未登录</td></tr>
        <tr><td>请登录:</td></tr>
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
</body>
</html>
