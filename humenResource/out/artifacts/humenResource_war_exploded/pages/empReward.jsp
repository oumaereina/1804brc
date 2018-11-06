<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/31
  Time: 9:34
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
    <title>奖惩信息</title>
</head>
<body>
<button class="layui-btn layui-btn-sm layui-btn-primary">
    <i class="layui-icon"><a href="pages/emp.jsp">＜</a> </i>
</button>
<form>
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>时间</th>
            <th>奖罚金额</th>
            <th>原因</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.reward}" var="i">
            <tr>
                <td>${i.getRm_time()}</td>
                <td>${i.getRm_money()}</td>
                <td>${i.getRm_reason()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
</html>
