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
<script src="../js/jquery-3.2.1.js"></script>
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
    #u3{
        font-size: 14px;
        list-style-type: none;

    }
    #u2{
        font-size: 14px;
        list-style-type: none;
        float: left;
    }
    #u4{
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
    #d3{
        position: relative;
    }
    #d4{
        margin-top: 60px;
    }
</style>
<body>
<div id="d1">
    <c:if test="${sessionScope.inviteMsg!=null&&sessionScope.inviteMsg.getI_STATE()!=1}">
        <ul id="u1">
            <li>消息通知:</li>
            <li>您好，您的简历已被面试官通过，请及时查看信息并与面试官取得联系,面试时间:${requestScope.inviteMsg.getI_DATE()}</li>
            <li>点击<a href="visitor/checkInvite?inviteId=${sessionScope.inviteMsg.getI_ID()}">确认</a>表示同意参加面试，稍后面试官会联系您</li>
        </ul>
    </c:if>

</div>
<div id="d2">
    <ul id="u2">
        <li>你好，${sessionScope.visitor.getV_name()}</li>
        <c:if test="${sessionScope.emp!=null}">
            <li>您已被录取，员工账号：${sessionScope.emp.getE_name()}密码：${sessionScope.emp.getE_pass()}</li>
        </c:if>
    </ul>
</div>
<div id="d3">
    <ul id="u3">
        <li><a href="pages/visitorResume.jsp">简历管理</a></li>
        <li><a href="visitor/deleteSession">退出</a> </li>
    </ul>
</div>
<div id="d4">
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
                <c:if test="${sessionScope.inviteMsg==null}">
                    <td><a href="pages/resume.jsp">投递简历</a> </td>
                </c:if>
            </tr>
        </table>
    </c:forEach>
</div>
<div style="position: relative" id="d5">
    <c:forEach var="i" end="${sessionScope.totalPages}" begin="1">
        <ul id="u4">
            <li><a href="visitor/paging?currentPage=${i}">${i}</a></li>
        </ul>
    </c:forEach>
</div>
</body>

</html>
