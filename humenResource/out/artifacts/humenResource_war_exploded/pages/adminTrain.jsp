<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/27
  Time: 0:07
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
    <title>培训管理</title>
</head>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<script src="../js/jquery-3.2.1.js"></script>
<body>
<button class="layui-btn layui-btn-sm layui-btn-primary">
    <i class="layui-icon"><a href="pages/admin.jsp">＜</a> </i>
</button>
<div class="layui-collapse">
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">发布培训信息</h2>
        <div class="layui-colla-content ">
            <form action="train/addTrain" method="post">
                <ul>
                    <li>主题<input name="t_other" class="tr" msg="主题" id="no1" value=""></li>
                    <li>地点<input name="t_add" class="tr" msg="地点" value=""></li>
                    <li>开始时间<input name="t_start" type="date" class="tr" msg="开始时间" value=""></li>
                    <li>结束时间<input name="t_end" type="date" class="tr" msg="结束时间" value=""></li>
                    <li>内容<input name="t_content" class="tr" msg="内容" value=""></li>
                    <li><input type="submit" id="sub2"><input name="t_state" type="hidden" value=0></li>
                    <li>${requestScope.msg}</li>
                </ul>
            </form>
        </div>
    </div>
</div>
<form action="train/addEmpToTrain" method="post">
    <span class="layui-breadcrumb" lay-separator="|">
        <c:forEach items="${sessionScope.departments}" var="i">
            <a href="emp/EmpByDid?did=${i.getD_id()}">${i.getD_name()}</a>
        </c:forEach>
    </span>
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>选择</th>
            <th>员工编号</th>
            <th>姓名</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.emps}" var="i">
            <tr>
                <td><input type="checkbox" name="log" value="${i.getE_id()}"></td>
                <td>${i.getE_name()}</td>
                <td>${i.getE_realName()}</td>
            </tr>
        </c:forEach>
        <tr><td>${requestScope.msg}</td></tr>
        </tbody>
    </table>
    删除<input type="button" id="delTrain" value="">
    <input type="button" id="train" value="查看培训课程">
    <select id="s2" name="tid">
    </select><br/>
    <input type="hidden" name="tid" id="t" >
    <input type="submit" value="添加" id="sub1">
</form>
<%--<ul id="emp">

</ul>--%>
</body>
<script>
    $(function () {
        /*$("#no1").mouseleave(function () {
            if($(this).val()==""){
                alert("标题不能为空")
                $("#sub2").prop("disabled",true)
            }else {
                $("#sub2").prop("disabled",false)
            }
        })*/
        $("#sub2").click(function (e) {
            var num=0;
            var str="";
            $(".tr").each(function(n){

                if($(".tr").val()=="")
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
        $("#sub1").click(function (e) {
            if($("input[name='log']").val()==null||$("input[name='log']").val()==""){
                alert("不选还想提交")
                e.preventDefault();
            }
        })
        $("#s2").change(function () {
            $("#t").val($("#s2").val())
            $("#delTrain").val($("#s2").val())
        })
        $("#train").click(function () {
            $.ajax({
                type: "get",
                url: "train/showTrain",
                dataType: "json",
                async: false,
                data: {},
                success: function (obj) {
                    $("#s2").empty();
                    for (var i = 0; i < obj.length; i++) {
                        $("#s2").append("<option name='' value='" + obj[i].t_id + "'>" + obj[i].t_other + "</option>");
                    }

                }
            });
        });
        $("#delTrain").click(function () {
            $.ajax({
                type: "get",
                url: "train/delTrain",
                dataType: "json",
                async: false,
                data: {tid:$("#delTrain").val()},
                success: function (obj) {

                }
            });
        });
        layui.use('element', function(){
            var element = layui.element;

            //…
        });
    })
</script>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
</html>
