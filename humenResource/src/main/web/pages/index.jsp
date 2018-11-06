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
    .oth{
        font-size: 8px;
    }
    #t1{
        font-size: 14px;
        border:solid 1px #F2F2F2;
        width: 1600px;
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
    td{
        padding-left: 50px;
        padding-top: 20px;
    }
    .div1{

        margin:0 auto;

        background: #F2F2F2;

        width:70px;

        height:25px;

        border:1px solid darkslategray;

        border-radius:30px;

        text-align: center;

        line-height: 5px;

    }
</style>
<body>
    <ul id="u1">
        <li><p>游客:您还未登录，请先<a href="pages/visitorLogin.jsp">登录</a></p></li>
        <li><a href="pages/visitorRegister.jsp">游客注册</a></li>
        <li><a href="pages/empLogin.jsp">员工登录通道</a> </li>
        <li>${requestScope.msg}</li>
    </ul>
<hr>
<p>${sessionScope.EmpMsg}</p>
<div >
    <c:forEach items="${sessionScope.employments}" var="i">
        <table id="t1">
            <tr>
                <td>职位：${i.getEM_POST()}</td>
                <td></td>
                <td></td>
                <td></td>
                <td>公司：${i.getEM_COMPANY()}</td>
            </tr>
            <tr>
                <td>薪资待遇：${i.getEM_SALARY()}</td>
                <td>工作地点：${i.getEM_ADD()}</td>
                <td>学历要求：${i.getEM_EDU()}</td>
                <td>工作经验：${i.getEM_EXP()}</td>
                <td>人数：${i.getEM_PEOPLE()} 人</td>
            </tr>
            <tr>
                <td class="oth"><div class="div1"><p>绩效奖金</p></div></td>
                <td class="oth"><div class="div1"><p>五险一金</p></div></td>
                <td class="oth"><div class="div1"><p>年终分红</p></div></td>
                <td class="oth"><div class="div1"><p>包吃包住</p></div></td>
                <td>发布日期：${i.getEM_DATE()}</td>
            </tr>
            <tr>
                <c:if test="${sessionScope.visitor!=null}">
                    <td><a href="pages/resume.jsp">投递简历</a> </td>
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
