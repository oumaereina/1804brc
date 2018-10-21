<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/21
  Time: 23:17
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
    <title>简历管理</title>
</head>
<body>
<div>
    <ul>
        <li><a href="admin/selectAllResumeAdmin">所有简历</a> </li>
        <li><a href="admin/selectNoReadResumeAdmin">未读简历</a></li>
        <li><a href="admin/selectReadResumeAdmin">已读简历</a></li>
    </ul>
</div>
<div>
    <table>
        <c:forEach items="${requestScope.resumes}" var="i">
            <tr>
                <td>姓名:</td>
                <td>${i.getR_name()}</td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>${i.getR_sex()}</td>
            </tr>
            <tr>
                <td>民族:</td>
                <td>${i.getR_nation()}</td>
            </tr>
            <tr>
                <td>籍贯:</td>
                <td>${i.getR_native_place()}</td>
            </tr>
            <tr>
                <td>政治面貌:</td>
                <td>${i.getR_pol_sta()}</td>
            </tr>
            <tr>
                <td><a href="admin/addInvite?vid=${i. getR_vid()}">发送面试邀请</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
