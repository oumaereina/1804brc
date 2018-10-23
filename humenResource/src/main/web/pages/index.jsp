<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/19
  Time: 10:15
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
    <title>500强企业主页</title>
</head>
<style>
    #t1{
        font-size: 14px;
    }
    #u1{
        font-size: 14px;
        list-style-type: none;
    }
    #u2{
        font-size: 14px;
        list-style-type: none;
        float: left;
    }
</style>
<body>
<c:if test="${sessionScope.visitor==null}">
    <ul id="u1">
        <li><p>您还未登录，请先<a href="pages/visitorLogin.jsp">登录</a></p></li>
        <li><a href="pages/visitorRegister.jsp">游客注册</a></li>
    </ul>
</c:if>
<hr>
<p>${requestScope.EmpMsg}</p>
<div>
    <c:forEach items="${requestScope.employments}" var="i">
        <table id="t1">
            <tr>
                <td>${i.getEM_POST()}</td>
                <td>${i.getEM_COMPANY()}</td>
            </tr>
            <tr>
                <td>${i.getEM_SALARY()}</td>
                <td>${i.getEM_ADD()}</td>
                <td>${i.getEM_EDU()}</td>
                <td>${i.getEM_EXP()}</td>
                <td>${i.getEM_PEOPLE()}</td>
            </tr>
            <tr>
                <td>绩效奖金</td>
                <td>五险一金</td>
                <td>年终分红</td>
                <td>包吃包住</td>
                <td>${i.getEM_DATE()}</td>
            </tr>
            <tr>
                <c:if test="${sessionScope.visitor!=null}">
                    <td><a href="resume.jsp">投递简历</a> </td>
                </c:if>
            </tr>
        </table>
    </c:forEach>
</div>
<div style="position: relative" id="div3">
    <c:forEach var="i" end="${totalPages}" begin="1">
        <ul id="u2">
            <li><a href="employment/showEmp?currentPage=${i}">${i}</a></li>
        </ul>
    </c:forEach>
</div>
</body>
</html>
