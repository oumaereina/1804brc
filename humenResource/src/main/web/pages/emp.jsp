<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/24
  Time: 13:19
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
    <title>员工页面</title>
</head>
<body>
<div>
    <ul>
        <li>您好,${requestScope.emp.getE_NAME()},${requestScope.emp.getE_PHONE()}</li>
    </ul>
</div>
</body>
</html>
