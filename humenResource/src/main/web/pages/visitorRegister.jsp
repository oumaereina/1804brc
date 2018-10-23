<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/19
  Time: 12:23
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
    <title>游客注册</title>
</head>
<script src="js/jquery-3.2.1.js"></script>
<style>
    #p2{
        color: crimson;
    }
</style>
<body>
<form action="visitor/visitorRegister" method="post">
    <table>
        <tr>
            <td> 账号：</td>
            <td><input name="v_name" id="name"></td>
            <td><p id="p1"></p></td>
        </tr>
        <tr>
            <td> 密码：</td>
            <td><input name="v_pass" type="password" id="pass"></td>
        </tr>
        <tr>
            <td> 再次输入密码：</td>
            <td><input type="password" id="checkPass"></td>
            <td><p id="p2"></p></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册" id="register"></td>
        </tr>
    </table>

</form>
<p>${requestScope.msg}</p>
</body>
<script>
   $(function () {
       $("#name").blur(function () {
           $.ajax({
               type:"get",
               url:"visitor/checkName",
               data:{v_name:$("input[name='v_name']").val()},
               success:function (obj) {
                   if(obj=="true"){
                       $("#p1").html("可以注册")
                   }else {
                       $("#p1").html("已存在用户名")
                       $("#register").disabled()
                   }
               }
           })
       })

       $("#checkPass").blur(function () {
           var v_pass=$("#pass").val()
           var c_pass=$("#checkPass").val()
           if(v_pass!=c_pass){
               $("#p2").html("两次密码输入不一致")
               $("#register").prop("disabled",true)
           }else {
               $("#p2").html("")
               $("#register").prop("disabled",false)
           }
       })
   })
</script>
</html>
