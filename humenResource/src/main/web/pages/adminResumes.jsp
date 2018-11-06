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
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<script src="../js/jquery-3.2.1.js"></script>
<body>
<button class="layui-btn layui-btn-sm layui-btn-primary">
    <i class="layui-icon"><a href="pages/admin.jsp">＜</a> </i>
</button>
<div>
    <ul>
        <li><a href="resume/selectAllResumeAdmin">所有简历</a> </li>
        <li><a href="resume/selectNoReadResumeAdmin">未读简历</a></li>
        <li><a href="resume/selectReadResumeAdmin">已读简历</a></li>
    </ul>
</div>
<div>
    <table  class="layui-table" lay-skin="line">
        <c:forEach items="${requestScope.resumes}" var="i">
            <tr><td>简历</td></tr>
            <tr>
                <td>姓名:</td>
                <td>${i.getR_name()}</td>
                <td>电话:</td>
                <td>${i.getR_phone()}</td>
                <td>性别:</td>
                <td>${i.getR_sex()}</td>
                <td>电子邮件:</td>
                <td>${i.getR_health()}</td>
                <td>学历:</td>
                <td>${i.getR_edu()}</td>
            </tr>
            <tr>
                <td>民族:</td>
                <td>${i.getR_nation()}</td>
                <td>籍贯:</td>
                <td>${i.getR_native_place()}</td>
                <td>政治面貌:</td>
                <td>${i.getR_pol_sta()}</td>
                <td>英语等级:</td>
                <td>${i.getR_english()}</td>
                <td>专业:</td>
                <td>${i.getR_major()}</td>
            </tr>
            <tr>
                <td>地址:</td>
                <td>${i.getR_add()}</td>
                <td>身份证:</td>
                <td>${i.getR_idc()}</td>
                <td>学校:</td>
                <td>${i.getR_school()}</td>
                <td>工作意向:</td>
                <td>${i.getR_hobby()}</td>
                <td>自我评价:</td>
                <td>${i.getR_self()}</td>

            </tr>
            <tr>
                <td><a href="invite/addInvite1?vid=${i. getR_vid()}" style="color: crimson">发送面试邀请</a></td>
            <%--<c:if test="${i.getR_state()!=2}">
                <td><a href="emp/addEmp?vid=${i. getR_vid()}">录用此人</a> </td>
            </c:if>--%>
            </tr>
            <tr><td>${requestScope.msg}</td></tr>
        </c:forEach>
    </table>
</div>
</body>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
</html>
