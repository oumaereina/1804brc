<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/23
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<script src="../js/jquery-3.2.1.js"></script>
<head>
    <base href="<%=basePath%>"/>
    <title>游客简历管理</title>
</head>
<body>
<div>
    <ul>
        <li><a href="resume/selectResume">查看简历</a></li>
        <li><a href="">修改简历</a></li>
    </ul>
</div>
${requestScope.resumes}
</body>
</html>
