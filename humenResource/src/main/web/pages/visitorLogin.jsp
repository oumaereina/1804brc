<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/20
  Time: 17:37
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
    <title>游客登录</title>
</head>
<script src="../js/jquery-3.2.1.js"></script>
<body>
<form action="visitor/visitorLogin" method="post">
    <table>
        <tr><td>您还未登录</td></tr>
        <tr><td>请登录:</td></tr>
        <tr>
            <td> 账号：</td>
            <td><input name="v_name" class="ins" msg="用户名"></td>
            <td></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input name="v_pass" type="password" class="ins"  msg="密码"></td>
            <td></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"  id="sub1"></td>
        </tr>
        <tr><td><p style="color: crimson">${requestScope.msg}</p></td></tr>
    </table>
</form>
</body>
<script>
    $("#sub1").click(function (e) {

            var num = 0;
            var str = "";
            $(".ins").each(function (n) {
                if ($(".ins").val() == "") {
                    num++;
                    str += $(this).attr("msg") + "不能为空！\r\n";
                }
            });
            if (num > 0) {
                alert(str);
                e.preventDefault();
                return false;
            }
            else {
                return true;
            }
        })

</script>
</html>
