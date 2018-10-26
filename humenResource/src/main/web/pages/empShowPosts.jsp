<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/26
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<script src="../js/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<style>
    ul{
        list-style-type: none;
    }
</style>

<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
</head>
<body>
<button class="layui-btn layui-btn-sm">
    <i class="layui-icon"><a href="pages/emp.jsp">&#xe602;</a> </i>
</button>
<div>
    <c:forEach items="${sessionScope.posts}" var="i">
        <ul>
            <li><a href="emp/showEmpByPid?pid=${i.getP_id()}">${i.getPname()}</a> </li>
        </ul>
    </c:forEach>
</div>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>电子邮件</th>
        <th>联系方式</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.emps}" var="i">
        <tr>
            <td>${i.getE_realName()}</td>
            <td>${i.getE_sex()}</td>
            <td>${i.getE_mail()}</td>
            <td>${i.getE_phone()}</td>
            <c:if test="${i.getE_state()==1}">
                <td>试用期</td>
            </c:if>
            <c:if test="${i.getE_state()==2}">
                <td>正式员工</td>
            </c:if>
            <c:if test="${i.getE_state()==3}">
                <td>已离职</td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
    <%--<div style="position: relative" id="d5">
        <c:forEach var="i" end="${totalPages}" begin="1">
            <ul id="u4">
                <li><a href="emp/showEmpByPid?currentPage=${i}">${i}</a></li>
            </ul>
        </c:forEach>
    </div>--%>
</table>
</body>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
</html>
