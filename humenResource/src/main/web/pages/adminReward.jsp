<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/31
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<script src="../js/jquery-3.2.1.js"></script>
<meta charset="UTF-8">
<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<!-- 引入Bootstrap核心样式文件 -->
<link href="../css/bootstrap.css" rel="stylesheet">
<!-- 引入jQuery核心js文件 -->
<script src="../js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="../js/bootstrap.min.js"></script>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
</head>
<body>
<%--<table class="table table-hover" border="1">
    <tr>
        <th>部门</th>
        <th>职位</th>
        <th>员工</th>
        <th>操作</th>
    </tr>
    <tr>
        <th>部门</th>
        <th>职位</th>
        <th>员工</th>
        <th>操作</th>
    </tr>
</table>--%>
<button class="layui-btn">
    <i class="layui-icon"><a href="pages/admin.jsp">＜</a> </i>
</button>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>部门</th>
        <th>职位</th>
        <th>员工</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><select id="s1">
            <c:forEach items="${sessionScope.departments}" var="i">
                <option value="${i.getD_id()}">${i.getD_name()}</option>
            </c:forEach>
        </select></td>
        <td>
            <select id="s2"></select>
        </td>
        <td><select id="s3"></select></td>
        <td><button class="layui-btn layui-btn-primary" value="" id="but1">查询</button></td>
    </tr>
    </tbody>
</table>
<hr>
<table class="layui-table" >
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>时间</th>
        <th>奖罚金额</th>
        <th>原因</th>
        <th colspan="2">操作</th>
    </tr>
    </thead>
    <tbody id="tb">

    </tbody>
</table>
<p>添加奖惩</p>
<form action="reward/addReward" method="post">
    <table class="layui-table" >
        <tr>
            <td>金额<input name="rm_money" class="ins" msg="金额" type="number"><input name="rm_eid" value="" type="hidden" id="rm_eid"></td>
            <td>原因<input name="rm_reason" class="ins" msg="原因"><input name="rm_state" value=0 type="hidden"></td>
        </tr>
        <tr><td><input type="submit" value="添加" id="sub1"></td></tr>
    </table>
</form>
</body>
<script>
    $(function () {
        $("#sub1").click(function (e) {
            $(".ins").each(function(n){
                if($(".ins").val()==""){
                    alert($(this).attr("msg")+"不能为空")
                    e.preventDefault()
                }
            });
        })
        $("#s1").change(function () {
            $.ajax({
                type:"get",
                url:"admin/findPosts",
                dataType:"json",
                async:false,
                data:{"P_D_ID":$("#s1").val()},
                success:function (obj) {
                    $("#s2").empty();
                    $("#s3").empty();
                    for(var i=0; i<obj.length;i++){
                        $("#s2").append("<option name='' value='"+obj[i].p_id+"'>"+obj[i].pname+"</option>");
                    }
                }
            });
        });

        $("#s2").change(function () {
            $.ajax({
                type:"get",
                url:"admin/findEmps",
                dataType:"json",
                async:false,
                data:{"P_D_ID":$("#s2").val()},
                success:function (obj) {
                    $("#s3").empty();
                    for(var i=0; i<obj.length;i++){
                        $("#s3").append("<option name='' value='"+obj[i].e_id+"'>"+obj[i].e_realName+"</option>");
                    }
                }
            });
        });
        $("#s2").change(function () {
            $("#but1").val($("#s3").val())
            $("#rm_eid").val($("#s3").val())
        });
        $("#s3").change(function () {
            $("#but1").val($("#s3").val())
            $("#rm_eid").val($("#s3").val())
        });
        $("#but1").click(function () {
            $("#tb").empty()
            $.ajax({
                type:"get",
                url:"reward/showEmpRewardAdmin",
                dataType:"json",
                async:false,
                data:{"eid":$("#but1").val()},
                success:function (obj) {
                    for(var i=0; i<obj.length;i++){
                        $("#tb").prepend("<tr><td>"+obj[i].rm_time+"</td>" +
                            "<td>"+obj[i].rm_money+"</td>" +
                            "<td>"+obj[i].rm_reason+"</td>" +
                            "<td><a href='reward/updateEmpReward?rmid="+obj[i].rm_id+"'>"+"修改"+"</a></td>" +
                            "</tr>"
                        );
                    }
                }
            });
        })
    })
</script>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
</html>
