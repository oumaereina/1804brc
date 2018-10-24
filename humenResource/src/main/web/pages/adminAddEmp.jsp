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
<script src="../js/jquery-3.2.1.js"></script>
<head>
    <base href="<%=basePath%>"/>
    <title>录取员工信息</title>
</head>
<body>
<div>
    <form action="" method="post">
        <ul>
            <li>账户名:</li>
            <li><input value="${requestScope.empName}" name="E_NAME"></li>
            <li>密码:</li>
            <li><input value="${requestScope.empPass}" name="E_PASS"></li>
            <li>姓名:</li>
            <li><input value="${requestScope.resume.getR_name()}" name="E_REALNAME"></li>
            <li>性别:</li>
            <li><input value="${requestScope.resume.getR_sex()}" name="E_SEX"></li>
            <li>电子邮箱:</li>
            <li><input value="${requestScope.resume.getR_health()}" name="E_MAIL"></li>
            <li>电话:</li>
            <li><input value="${requestScope.resume.getR_phone()}" name="E_PHONE"></li>
            <li>薪资:</li>
            <li><input value="" name="E_SALARY"></li>
            <li><input value="${requestScope.resume.getR_phone()}" name="E_STATE" type="hidden"></li>
            <select name="" id="s1">
                <option value="${null}" >选择部门</option>
                <c:forEach items="${requestScope.departments}" var="i">
                    <option name="E_D_ID" value="${i.getD_ID()}">${i.getD_NAME()}</option>
                </c:forEach>
            </select>
            <select name="" id="s2">

            </select>
        </ul>
        <p><input type="submit"></p>
    </form>
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
                    $("#s2").empty()
                    for(var i=0; i<obj.length;i++){
                        $("#s2").append("<option name='"+obj[i].P_ID+"' value=''>"+obj[i].P_NAME+"</option>");
                    }
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
                }
            });
        });
    })
</script>
</html>
