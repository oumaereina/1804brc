<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/19
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<div>
    <c:if test="${requestScope.inviteMsg!=null}">
        <ul>
            <li>面试邀请:</li>
            <li>${requestScope.inviteMsg}</li>
            <li>点击<a href="">确认</a>表示同意参加面试，稍后面试官会联系您</li>
        </ul>
    </c:if>
</div>
<div>
    <ul>
        <li>你好，${sessionScope.visitor.getV_name()}</li>
    </ul>
</div>
${requestScope.resumes}
<div>
    <ul>
        <li><a href="resume/selectResume">查看简历</a></li>
        <li><a href="">修改简历</a></li>
    </ul>
</div>
</body>
</html>
