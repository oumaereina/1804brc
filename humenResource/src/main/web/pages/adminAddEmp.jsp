<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/22
  Time: 16:10
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
    <title>录取员工信息</title>
</head>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<script src="../js/jquery-3.2.1.js"></script>
<body>
<button class="layui-btn layui-btn-sm layui-btn-primary">
    <i class="layui-icon"><a href="pages/admin.jsp">＜</a> </i>
</button>
<div>
    <form action="emp/addeee" method="post">
        <ul>
            <li>账户名:</li>
            <li><input value="${requestScope.empName}" name="e_name" class="tr" msg="账户名" ></li>
            <li>密码:</li>
            <li><input value="${requestScope.empPass}" name="e_pass" class="tr" msg="密码" ></li>
            <li>姓名:</li>
            <li><input value="${requestScope.resume.getR_name()}" name="e_realName" class="tr" msg="姓名"></li>
            <li>性别:</li>
            <li><input value="${requestScope.resume.getR_sex()}" name="e_sex" class="tr" msg="性别"></li>
            <li>年龄:</li>
            <li><input value=33 name="e_age" type="number" class="tr" msg="年龄"></li>
            <li>电子邮箱:</li>
            <li><input value="${requestScope.resume.getR_health()}" name="e_mail" class="tr" msg="电子邮箱"></li>
            <li>电话:</li>
            <li><input value="${requestScope.resume.getR_phone()}" name="e_phone" type="number" class="tr" msg="电话"></li>
            <li>薪资:</li>
            <li><input value="" name="e_salary" class="tr" msg="薪资"a><input name="e_vid" value="${requestScope.vid}" type="hidden"></li>
            <li><input value=1 name="e_state" type="hidden"><input name="e_date" value="${requestScope.date}" type="hidden"></li>
            <select name="e_d_id" id="s1" class="tr" msg="部门">
                <option value="${null}" >选择部门</option>
                <c:forEach items="${requestScope.departments}" var="i">
                    <option name="" value="${i.getD_id()}">${i.getD_name()}</option>
                </c:forEach>
            </select>
            <select name="e_p_id" id="s2" class="tr" msg="岗位">
                <option value="${null}" >选择岗位</option>
            </select>
            <li><p><input type="submit" id="sub2"></p></li>
        </ul>
    </form>
    <p id="p1">${requestScope.msg}</p>
</div>
</body>
<script>
    $(function () {
        $("#s1").change(function () {
            $.ajax({
                type:"get",
                url:"admin/findPosts",
                dataType:"json",
                async:false,
                data:{"P_D_ID":$("#s1").val()},
                success:function (obj) {
                    $("#s2").empty();
                    for(var i=0; i<obj.length;i++){
                        $("#s2").append("<option name='' value='"+obj[i].p_id+"'>"+obj[i].pname+"</option>");
                        var a= $("#p1").text();
                        a+=$("#p1").html(obj[i].P_NAME);
                    }

                }
            });
        });
    })
    //var arr=eval("("+obj+")");
    /* var arr=obj
     for(var i in arr){
     var name=arr[i];
     $("#s2").prepend("<option name='E_P_ID' value=''>"+name+"</option>")
     }*/
    /* jQuery.each(obj.Post, function (i,item) {
     $("#s2").prepend("<option name='E_P_ID' value=''>"+item.P_NAME+"</option>")
     })*/
    /*  $.each(obj,function (i,item) {
     var name = item.P_NAME
     $("#s2").prepend("<option name='E_P_ID' value=''>"+name+"</option>")
     })*/
    $(function () {
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

        })
    })
</script>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
</html>
