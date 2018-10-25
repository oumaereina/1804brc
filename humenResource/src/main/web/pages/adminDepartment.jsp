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
    #b1{
        font-size: 16px;
    }
    .uu{
        list-style-type: none;
    }
    #d1{
        position: relative;
    }
    #d2{
        position: relative;

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
                    <a href="post/showPostByDid?did=${i.getD_ID()}">${i.getD_NAME()}</a>
                    <p>人数：<a href="emp/showDepNum?did=${i.getD_ID()}">${i.getD_NUM()} 人</a></p>
                </li>
                <li><a href="department/delDep?did=${i.getD_ID()}" id="a1"> 删除</a><input type="hidden" value="${i.getD_NUM()}" id="num">
                </li>
                <li><a href="department/updateDep1?did=${i.getD_ID()}">修改</a> </li>
              <%--  <li><input name="D_NAME" value="${i.getD_NAME()}"><input type="submit" value="修改">
                    <input name="D_NUM" value="${i.getD_NUM()}" type="hidden">
                    <input name="D_ID" value="${i.getD_ID()}" type="hidden">
                </li>--%>
            </ul>
        </c:forEach>
    </form>
</div>
<div>
    <form action="department/addDep" method="post">
        <ul class="uu">
            <li>添加部门</li>
            <li>部门名：<input name="D_NAME"><input type="hidden" name="E_NUM" value=0></li>
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
                <li><a href="">${i.getPname()}</a> 该岗位有${i.getP_NUM()}人</li>
                <li><a href="post/updatePost1?pid=${i.getP_id()}">修改</a><a href="post/delPost?pid=${i.getP_id()}">删除</a></li>
            </ul>
        </c:forEach>
    </form>
</div>
<div>
 <form action="post/addPost" method="post">
     <p>添加岗位</p>
     <select name="P_D_ID" id="s1">
         <c:forEach items="${sessionScope.departments}" var="i">
             <option name="" value="${i.getD_ID()}">${i.getD_NAME()}</option>
         </c:forEach>
     </select>
     岗位名:<input name="pname" type="text"><input type="hidden" value=0 name="P_NUM">
     <input type="submit">
 </form>
</div>
<hr>
<div>
    <c:forEach items="${requestScope.emps}" var="i">
        <ul id="u3" class="uu">
            <li>${i.getE_realName()}</li>
        </ul>
    </c:forEach>
</div>

</body>
<script>
    $(function () {

    })
</script>
</html>
