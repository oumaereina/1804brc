<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/24
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<style>
    #b1 {
        font-size: 16px;
    }

    .uu {
        list-style-type: none;
    }

    #d1 {
        position: relative;
    }

    #d2 {
        position: relative;

    }
    #t1{
        width: 900px;
        font-size: 14px;
        border:solid 1px #F2F2F2;
    }
</style>

<head>
    <base href="<%=basePath%>"/>
    <title>部门管理</title>
</head>
<body id="b1">
<div id="d1">
    <form action="department/updateDep" method="post">
        <c:forEach items="${sessionScope.departments}" var="i">
            <ul class="uu">
                <li>
                    <a href="post/showPostByDid?did=${i.getD_id()}">${i.getD_name()}</a>
                    <p>人数：<a href="emp/showDepNum?did=${i.getD_id()}">${i.getD_NUM()} 人</a></p>
                </li>
                <li><a href="department/delDep?did=${i.getD_id()}" id="a1"> 删除</a><input type="hidden"
                                                                                         value="${i.getD_NUM()}"
                                                                                         id="num">
                </li>
                <li><a href="department/updateDep1?did=${i.getD_id()}">修改</a></li>
            </ul>
        </c:forEach>
    </form>
</div>
<div>
    <form action="department/addDep" method="post">
        <ul class="uu">
            <li>添加部门</li>
            <li>部门名：<input name="D_name"><input type="hidden" name="D_NUM" value=0></li>
            <li></li>
            <li><input type="submit"></li>
        </ul>
    </form>
</div>

<p>${requestScope.msg}</p>
<hr>
<div id="d2">
    <form action="" method="post">
        <c:forEach items="${sessionScope.posts}" var="i">
            <ul class="uu">
                <li><a>${i.getPname()}</a> 该岗位有${i.getP_NUM()}人</li>
                <li><a href="post/updatePost1?pid=${i.getP_id()}">修改</a><a href="post/delPost?pid=${i.getP_id()}">删除</a>
                </li>
            </ul>
        </c:forEach>
    </form>
</div>
<div>
    <form action="post/addPost" method="post">
        <p>添加岗位</p>
        <select name="P_D_ID" id="s1">
            <c:forEach items="${sessionScope.departments}" var="i">
                <option name="" value="${i.getD_id()}">${i.getD_name()}</option>
            </c:forEach>
        </select>
        岗位名:<input name="pname" type="text"><input type="hidden" value=0 name="P_NUM">
        <input type="submit">
    </form>
</div>
<hr>
<div>
    <table id="t1">
        <tr>
            <td>员工姓名</td>
            <td>入职时间</td>
            <td colspan="2">员工状态</td>
            <td>岗位调整</td>
        </tr>
        <c:forEach items="${requestScope.emps}" var="i" varStatus="loop">
            <tr>
                <td>${i.getE_realName()}</td>
                <td>${i.getE_date()}</td>
                <c:if test="${i.getE_state()==1}">
                    <td>试用期</td>
                    <td><a href="emp/positive?eid=${i.getE_id()}">转正</a> </td>
                    <td><a href="emp/updateDP?eid=${i.getE_id()}">换岗</a></td>
                </c:if>
                <c:if test="${i.getE_state()==2}">
                    <td>正式员工</td>
                    <td><a href="emp/dismission?eid=${i.getE_id()}">离职</a></td>
                    <td><a href="emp/updateDP?eid=${i.getE_id()}">换岗</a></td>
                </c:if>
                <c:if test="${i.getE_state()==3}">
                    <td>已离职</td>
                    <td>离职原因:${dis[loop.count-1].dm_result}</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
<script>
    $(function () {

    })
</script>
</html>
