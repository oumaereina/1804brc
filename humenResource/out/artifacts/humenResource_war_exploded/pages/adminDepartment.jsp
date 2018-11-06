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

</style>

<head>
    <base href="<%=basePath%>"/>
    <title>部门管理</title>
</head>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<script src="../js/jquery-3.2.1.js"></script>
<body id="b1">
<button class="layui-btn layui-btn-sm layui-btn-primary">
    <i class="layui-icon"><a href="pages/admin.jsp">＜</a> </i>
</button>

<div id="d1">
    <form action="department/updateDep" method="post">

            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>部门名</th>
                    <th>人数</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.departments}" var="i">
                <tr>
                    <td><a href="post/showPostByDid?did=${i.getD_id()}">${i.getD_name()}</a></td>
                    <td><a href="emp/showDepNum?did=${i.getD_id()}">${i.getD_NUM()}</a></td>
                    <td><a href="department/delDep?did=${i.getD_id()}" id="a1"> 删除</a>
                        <input type="hidden" value="${i.getD_NUM()}"id="num">
                        /
                        <a href="department/updateDep1?did=${i.getD_id()}">修改</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
       <%--     <ul class="uu">
                <li>
                    <a href="post/showPostByDid?did=${i.getD_id()}">${i.getD_name()}</a>
                    <p>人数：<a href="emp/showDepNum?did=${i.getD_id()}">${i.getD_NUM()} 人</a></p>
                </li>
                <li><a href="department/delDep?did=${i.getD_id()}" id="a1"> 删除</a><input type="hidden"
                                                                                         value="${i.getD_NUM()}"
                                                                                         id="num">
                </li>
                <li><a href="department/updateDep1?did=${i.getD_id()}">修改</a></li>
            </ul>--%>

    </form>
</div>
<div>
    <form action="department/addDep" method="post">
        <ul class="uu">
            <li>添加部门</li>
            <li>部门名：<input name="D_name" id="name"><input type="hidden" name="D_NUM" value=0>
                <button type="submit" class="layui-btn" id="sub1">立即提交</button>
            </li>
        </ul>
    </form>
</div>

<p style="color: crimson">${requestScope.msg}</p>
<hr>
<div id="d2">
    <form action="" method="post">
        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>岗位</th>
                <th>人数</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.posts}" var="i">
                <tr>
                    <td><a>${i.getPname()}</a> </td>
                    <td>${i.getP_NUM()}</td>
                    <td><a href="post/updatePost1?pid=${i.getP_id()}">修改</a>
                        /
                        <a href="post/delPost?pid=${i.getP_id()}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
<div>
    <form action="post/addPost" method="post">
        <p>添加岗位</p>
        <select name="P_D_ID" id="s1" lay-verify="">
            <c:forEach items="${sessionScope.departments}" var="i">
                <option name="" value="${i.getD_id()}">${i.getD_name()}</option>
            </c:forEach>
        </select>
        岗位名:<input name="pname" type="text" id="name2"><input type="hidden" value=0 name="P_NUM">
        <button type="submit" class="layui-btn" id="sub2">立即提交</button>
    </form>
</div>
<hr>
<div>
    <table class="layui-table" id="t1">
        <colgroup>
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>员工姓名</th>
            <th>入职时间</th>
            <th colspan="2">员工状态</th>
            <th>岗位调整</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.emps}" var="i" varStatus="loop">
            <tr>
                <td>${i.getE_realName()}</td>
                <td>${i.getE_date()}</td>
                <c:if test="${i.getE_state()==1}">
                    <td>试用期</td>
                    <td>
                        <a href="emp/positive?eid=${i.getE_id()}">转正</a>
                        /
                        <a href="emp/dismission?eid=${i.getE_id()}">开除
                        </a>
                    </td>
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
        </tbody>
    </table>

</div>

</body>
<script>
    $(function () {
        layui.use('form', function(){
            var form = layui.form;

            //各种基于事件的操作，下面会有进一步介绍
        });
        $("#sub2").click(function (e) {
            if($("#name2").val()==""){
                alert("部门名不能为空")
                e.preventDefault()
            }
        })
        $("#sub1").click(function (e) {
            if($("#name").val()==""){
                alert("岗位名不能为空")
                e.preventDefault()
            }
        })
    })
</script>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
</html>
