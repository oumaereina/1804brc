<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/21
  Time: 15:42
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
    <title>管理员</title>
</head>
<body>
<div>
    <ul>
        <li>您有${requestScope.noReadResumes}条未读简历</li>
    </ul>
</div>
<ul>
    <li><a href="admin/selectAllResumeAdmin">游客简历管理</a></li>
</ul>
</body>
</html>
