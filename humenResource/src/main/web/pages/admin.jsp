<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/21
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<link rel="stylesheet" href="../static/layui/layui/css/layui.css">
<script ></script>
<head>
    <base href="<%=basePath%>"/>
    <title>管理员</title>
</head>
<style>
    #a1{
        color: #01AAED;
    }
</style>
<body>
<div>
    <ul>
        <li>您有${requestScope.noReadResumes}条未读简历</li>
    </ul>
</div>
<div class="layui-tab layui-tab-card">
    <ul class="layui-tab-title">
        <li class="layui-this" ><a href="">员工管理</a> </li>
        <li><a href="admin/showMsg">消息</a></li>
        <li><a href="resume/selectAllResumeAdmin">游客简历管理</a></li>
        <li><a href="pages/adminEmployment.jsp">招聘信息管理</a></li>
        <li><a href="department/showDep">部门管理</a></li>
    </ul>
    <div class="layui-tab-content" style="height: 100px;">
        <div class="layui-tab-item layui-show">sda</div>
        <div class="layui-tab-item">

        </div>
        <div class="layui-tab-item">asd</div>
        <div class="layui-tab-item">sad</div>
        <div class="layui-tab-item">sad</div>
        <div class="layui-tab-item">6</div>
    </div>
</div>
<div>
    <c:if test="${requestScope.visitors!=null}">
        <c:forEach items="${requestScope.visitors}" var="i">
            <ul>
                <li>游客 ${i.getV_name()} 已确认面试邀请,请及时联系并考虑是否录取<a href="emp/addEmp?vid=" id="a1">录用此人</a></li>
            </ul>
        </c:forEach>
    </c:if>
</div>
<%--<div>
    <ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>--%>

</body>
<script src="../static/layui/layui/layui.all.js" charset="utf-8"></script>
<script>
    /*$("#u1").click(function () {
        $.ajax({
            type:"get",
            url:"",
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
    })*/
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {
            tabAdd: function(){
                //新增一个Tab项
                element.tabAdd('demo', {
                    title: '新选项'+ (Math.random()*1000|0) //用于演示
                    ,content: '内容'+ (Math.random()*1000|0)
                    ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                })
            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('demo', '44'); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('demo', '22'); //切换到：用户管理
            }
        };

        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });

    });
</script>
</html>
