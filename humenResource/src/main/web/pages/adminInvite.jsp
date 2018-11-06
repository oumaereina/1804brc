<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/26
  Time: 10:02
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
    <title>Title</title>
</head>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<script src="../js/jquery-3.2.1.js"></script>
<body>
<button class="layui-btn layui-btn-sm layui-btn-primary">
    <i class="layui-icon"><a href="pages/admin.jsp">＜</a> </i>
</button>
<form action="invite/addInvite2" method="post">
    <ul>
        <li><input type="date" name="I_DATE" id="time">
            <input type="hidden" name="I_VID" value="${sessionScope.vid}">
            <input type="hidden" name="I_STATE" value=0>
            <input type="submit" id="sub2">
        </li>
        <li><p style="color:crimson">${sessionScope.inviteMsg}</p></li>
    </ul>
</form>
</body>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
<script>
    $(function () {
        $("#sub2").click(function (e) {
            if($("#time").val()==""){
                alert("日期不能为空")
                e.preventDefault()
            }
        })
    })
</script>
</html>
