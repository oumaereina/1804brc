<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/11/1
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<script src="../js/jquery-3.2.1.js"></script>
<head>
    <base href="<%=basePath%>"/>
    <title>考勤记录</title>
</head>
<style>
    ul{
        float: left;
    }
</style>
<body>
<button class="layui-btn layui-btn-sm layui-btn-primary">
    <i class="layui-icon"><a href="pages/emp.jsp">＜</a></i>
</button>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>日期</th>
        <th>打卡记录</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.checkIns}" var="i">
        <tr>
            <td>${i.getC_time()}</td>
            <c:if test="${i.getC_state()==0}">
                <td>上班打卡</td>
            </c:if>
            <c:if test="${i.getC_state()==1}">
                <td>下班打卡</td>
            </c:if>
            <td>打卡成功</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div id="d3">
    <c:forEach var="i" end="${totalPages}" begin="1">
        <ul id="page">
            <li><a href="checkIn/showEmpCheckIn?currentPage=${i}">${i}</a></li>
        </ul>
    </c:forEach>
</div>
</body>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
</html>
