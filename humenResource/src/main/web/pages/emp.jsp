<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/24
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<head>
    <base href="<%=basePath%>"/>
    <title>员工页面</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">员工</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    欢迎您：员工编号${sessionScope.emp.getE_name()}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">员工信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">个人信息</a></dd>
                        <dd><a href="javascript:;">部门信息</a></dd>
                        <dd><a href="javascript:;">我的部门</a></dd>
                        <dd><a href=""></a></dd>
                    </dl>
                </li>
                <%--<li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">个人信息</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>--%>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>个人信息</legend>
        </fieldset>

        <table class="layui-table" lay-even="" lay-skin="nob">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>账号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>薪资</th>
                <th>邮箱</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${sessionScope.emp.getE_name()}</td>
                <td>${sessionScope.emp.getE_realName()}</td>
                <td>${sessionScope.emp.getE_sex()}</td>
                <td>${sessionScope.emp.getE_salary()}/月</td>
                <td>${sessionScope.emp.getE_mail()}</td>
            </tr>
            <tr>
                <td>电话</td>
                <td>部门</td>
                <td>岗位</td>
                <td>年龄</td>
                <td>入职时间</td>
            </tr>
            <tr>
                <td>${sessionScope.emp.getE_phone()}</td>
                <td>${sessionScope.depart.getD_NAME()}</td>
                <td>${sessionScope.post.getPname()}</td>
                <td>${sessionScope.emp.getE_age()}</td>
                <td>${sessionScope.emp.getE_date()}</td>
            </tr>
            <tr>
                <td>培训信息</td>
                <td>奖惩信息</td>
                <td>实收工资</td>
            </tr>
            <tr>


                <%--<td>${sessionScope.emp.getE_}</td>
                <td>${sessionScope.emp.getE_}</td>--%>
            </tr>
            <tr>
                <td><a href="">修改</a> </td>
            </tr>
            </tbody>
        </table>


    <div class="layui-footer">
    </div>
</div>

<div>
    <ul>
        <li>您好,</li>
    </ul>
</div>
</div>
</body>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>

</html>
