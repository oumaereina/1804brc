<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/24
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<style>
    #b1{
        font-size: 20px;
    }
    .uu{
        list-style-type: none;
    }
</style>
<head>
    <base href="<%=basePath%>"/>
    <title>部门管理</title>
</head>
<body id="b1">
<div>
    <form action="" method="post">
        <c:forEach items="${requestScope.departments}" var="i">
            <ul class="uu">
                <li><a href="post/showPostByDid?did=${i.getD_ID()}">${i.getD_NAME()}</a></li>
            </ul>
        </c:forEach>
    </form>
</div>
<div>
    <form action="" method="post">
        <c:forEach items="${requestScope.posts}" var="i">
            <ul class="uu">
                <li><a href="">${i.getP_NAME()}</a></li>
            </ul>
        </c:forEach>
    </form>
</div>
</body>
</html>
