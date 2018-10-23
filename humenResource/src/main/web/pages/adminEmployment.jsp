<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/23
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<script src="../js/jquery-3.2.1.js"></script>
<head>
    <base href="<%=basePath%>"/>
    <title>招聘信息管理</title>
</head>
<style>
    #page{
        list-style-type: none;
        float: left;
    }
</style>
<body>
<div id="d1">
    <ul>
        <li><a href="admin/showEmp">查看招聘信息</a> </li>
        <li><a href="" id="add">增加招聘信息</a></li>
    </ul>
</div>
<c:if test="${requestScope.employments!=null}">
    <div id="d2">
        <p>${requestScope.EmpMsg}</p>
        <c:forEach items="${requestScope.employments}" var="i">
            <table>
                <tr>
                    <td>${i.getEM_POST()}</td>
                    <td>${i.getEM_COMPANY()}</td>
                </tr>
                <tr>
                    <td>${i.getEM_SALARY()}</td>
                    <td>${i.getEM_ADD()}</td>
                    <td>${i.getEM_EDU()}</td>
                    <td>${i.getEM_EXP()}</td>
                    <td>${i.getEM_PEOPLE()}</td>
                </tr>
                <tr>
                    <td>绩效奖金</td>
                    <td>五险一金</td>
                    <td>年终分红</td>
                    <td>包吃包住</td>
                    <td>${i.getEM_DATE()}</td>
                </tr>
                <tr>
                    <td><a href="admin/deleteEmployment?EM_ID=${i.getEM_ID()}" onclick="add()">删除</a> </td>
                    <td><a href="">修改</a> </td>
                </tr>
            </table>
        </c:forEach>
    </div>
</c:if>
<div style="position: absolute" id="d3">
    <c:forEach var="i" end="${totalPages}" begin="1">
        <ul id="page">
            <li><a href="admin/showEmp?currentPage=${i}">${i}</a></li>
        </ul>
    </c:forEach>
</div>
<div id="d4">
    <form action="employment/addEmployment" method="post">
        <ul>
            <li>公司名</li>
            <li><input name="EM_COMPANY" class="ins" msg="公司名" type="text"></li>
            <li>岗位</li>
            <li><input name="EM_POST" class="ins" msg="岗位" type="text"></li>
            <li>需求人数</li>
            <li><input name="EM_PEOPLE" class="ins" msg="需求人数"type="text"></li>
            <li>地址</li>
            <li><input name="EM_ADD" class="ins" msg="地址" type="text"></li>
            <li>学历要求</li>
            <li><input name="EM_EDU" class="ins" msg="学历要求" type="text"></li>
            <li>月薪</li>
            <li><input name="EM_SALARY" class="ins" msg="月薪" type="text"></li>
            <li>工作经验</li>
            <li><input name="EM_EXP" class="ins" msg="工作经验" type="text" onblur="checkNull()"></li>
            <li><input type="submit" id="sub1" onmouseleave="checkNull()"></li>
        </ul>
    </form>
</div>
</body>
<script>
    function add() {
        if (!confirm("确认删除？删除后无法恢复")) {
            window.event.returnValue = false;
        }
    }
    function checkNull()
    {
        var num=0;
        var str="";
        $(".ins").each(function(n){
            if($(".ins").val()=="")
            {
                num++;
                str+=$(this).attr("msg")+"不能为空！\r\n";
            }
        });
        if(num>0)
        {
            alert(str);
            $("#sub1").prop("disabled",true)
            return false;
        }
        else
        {
            $("#sub1").prop("disabled",false)
            return true;
        }
    }
</script>
</html>
