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
        font-size: 14px;
        list-style-type: none;
        float: left;
    }
    .oth{
        font-size: 8px;
    }
    #t1{
        font-size: 14px;
        border:solid 1px #F2F2F2;
        width: 900px;
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
    #d3{
        position: relative
    }
    #d4{
        margin-left: 900px;
        position: relative;
        margin-top: -900px;
    }
</style>
<body>
<div id="d1">
    <ul >
        <li><a href="employment/showEmpAdmin">查看招聘信息</a> </li>
    </ul>
</div>
<c:if test="${requestScope.employments!=null}">
    <div id="d2">
        <p>${requestScope.EmpMsg}</p>
        <c:forEach items="${requestScope.employments}" var="i">
            <table id="t1">
                <tr>
                    <td>岗位：${i.getEM_POST()}</td>
                    <td>公司：${i.getEM_COMPANY()}</td>
                </tr>
                <tr>
                    <td>薪资：${i.getEM_SALARY()}/月</td>
                    <td>工作地点：${i.getEM_ADD()}</td>
                    <td>学历要求：${i.getEM_EDU()}</td>
                    <td>工作要求：${i.getEM_EXP()}</td>
                    <td>人数要求：${i.getEM_PEOPLE()}</td>
                </tr>
                <tr>
                    <td class="oth"><div class="div1"><p>绩效奖金</p></div></td>
                    <td class="oth"><div class="div1"><p>五险一金</p></div></td>
                    <td class="oth"><div class="div1"><p>年终分红</p></div></td>
                    <td class="oth"><div class="div1"><p>包吃包住</p></div></td>
                    <td>${i.getEM_DATE()}</td>
                </tr>
                <tr>
                    <td><a href="employment/deleteEmployment?EM_ID=${i.getEM_ID()}" onclick="add()">删除</a> </td>
                    <td><a href="employment/updateEmployment?EM_ID=${i.getEM_ID()}">修改</a> </td>
                </tr>
            </table>
        </c:forEach>
    </div>
</c:if>
<div id="d3">
    <c:forEach var="i" end="${totalPages}" begin="1">
        <ul id="page">
            <li><a href="employment/showEmpAdmin?currentPage=${i}">${i}</a></li>
        </ul>
    </c:forEach>
</div>
<div id="d4">
    <form action="employment/addEmployment" method="post">
        <ul id="u1">
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
            <li><input name="EM_EXP" class="ins" msg="工作经验" type="text" ></li>
            <li><input type="submit" id="sub1"></li>
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
    $("#sub1").click(function (e) {
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
            e.preventDefault()
            return false;
        }
        else
        {
            return true;
        }
    })
</script>
</html>
