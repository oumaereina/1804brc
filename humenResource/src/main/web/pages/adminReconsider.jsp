<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/11/1
  Time: 10:18
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
    <title>薪资复议</title>
</head>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<script src="../js/jquery-3.2.1.js"></script>
<body>
<button class="layui-btn layui-btn-sm layui-btn-primary">
    <i class="layui-icon"><a href="pages/admin.jsp">＜</a> </i>
</button>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>申请时间</th>
        <th>基本薪资</th>
        <th>当月结算薪资</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.reconsiders}" var="i" varStatus="loop">
        <tr>
            <td>${i.getRc_eid()}</td>
            <td>${emps[loop.count-1].getE_realName()}</td>
            <td>${i.getRc_time()}</td>
            <td>${emps[loop.count-1].getE_salary()}</td>
            <td>${salaries[loop.count-1].getS_salary()}</td>
            <td>
                <a href="reconsider/passReconsider?rc_id=${i.getRc_id()}" onclick="pass()">通过</a>
                /
                <a href="reconsider/failReconsider?rc_id=${i.getRc_id()}" onclick="fail()">驳回</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <p>${requestScope.msg}</p>
</table>
</body>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
<script>
    function fail() {
        if (!confirm("确认驳回？")) {
            window.event.returnValue = false;
        }
    }
    function pass() {
        if (!confirm("确认通过？")) {
            window.event.returnValue = false;
        }
    }
</script>
</html>
