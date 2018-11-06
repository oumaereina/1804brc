<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/11/2
  Time: 1:04
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
    <title>修改信息</title>
</head>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<script src="../js/jquery-3.2.1.js"></script>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
<body>
<button class="layui-btn layui-btn-sm layui-btn-primary">
    <i class="layui-icon"><a href="pages/admin.jsp">＜</a> </i>
</button>
<form class="layui-form" action="emp/updateEmp2" method="post">

    <input type="hidden" value="${requestScope.emp.getE_id()}" name="e_id" required lay-verify="required"
           placeholder="请输入姓名" autocomplete="off" class="layui-input">


    <input hidden type="hidden" value="${requestScope.emp.getE_name()}" name="e_name" required lay-verify="required"
           placeholder="请输入姓名" autocomplete="off" class="layui-input">


    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" value="${requestScope.emp.getE_realName()}" name="e_realName" required
                   lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" value="${requestScope.emp.getE_pass()}" name="e_pass" required lay-verify="required"
                   placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="text" value="${requestScope.emp.getE_age()}" name="e_age" required lay-verify="required"
                   placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" value="${requestScope.emp.getE_mail()}" name="e_mail" required lay-verify="required"
                   placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input type="text" value="${requestScope.emp.getE_phone()}" name="e_phone" required lay-verify="required"
                   placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="text" value="${requestScope.emp.getE_sex()}" name="e_sex" required lay-verify="required"
                   placeholder="请输入密码" autocomplete="off" class="layui-input">
            <input type="hidden" value="${requestScope.emp.getE_p_id()}" name="e_p_id">
            <input type="hidden" value="${requestScope.emp.getE_d_id()}" name="e_d_id">
            <input type="hidden" value="${requestScope.emp.getE_salary()}" name="e_salary">
            <input type="hidden" value="${requestScope.emp.getE_date()}" name="e_date">
            <input type="hidden" value="${requestScope.emp.getE_vid()}" name="e_vid">
            <input type="hidden" value="${requestScope.emp.getE_state()}" name="e_state">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input class="layui-btn" type="submit" value="立即提交">
        </div>
    </div>
</form>

<script>
    //Demo

</script>
</body>
</html>
