<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/22
  Time: 16:10
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
    <title>录取员工信息</title>
</head>
<body>
<div>
    <form action="" method="post">
        <ul>
            <li>姓名:</li>
            <li><input value="${requestScope.resume.getR_name()}" name="E_NAME"></li>
            <li>密码:</li>
            <li><input value="${requestScope.empPass}" name="E_PASS"></li>
            <li>电子邮箱:</li>
            <li><input value="${requestScope.resume.getR_health()}" name="E_PASS"></li>
            <li>电话:</li>
            <li><input value="${requestScope.resume.getR_phone()}" name="E_PHONE"></li>
            <select name="" id="">

            </select>
        </ul>
        <p><input type="submit"></p>
    </form>
</div>
</body>
</html>
