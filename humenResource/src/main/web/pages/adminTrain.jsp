<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/27
  Time: 0:07
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
    <title>培训管理</title>
</head>
<body>
<div>
    <form action="train/addTrain" method="post">
        <ul>
            <li><input name="t_other" ></li>
            <li><input name="t_add" ></li>
            <li><input name="t_start" type="date"></li>
            <li><input name="t_end" type="date" ></li>
            <li><input name="t_content" ></li>
            <li><input type="submit"><input name="t_state" type="hidden" value=0></li>
            <li>${requestScope.msg}</li>
        </ul>
    </form>
</div>
<a href="train/showTrain?tid=1">查询</a>
${requestScope.emps}
</body>
</html>
