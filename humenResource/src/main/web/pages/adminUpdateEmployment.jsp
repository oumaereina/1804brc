<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/25
  Time: 10:14
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
<script src="../js/jquery-3.2.1.js"></script>
<body>
<c:if test="${requestScope.employment!=null}">
    <div id="d4">
        <form action="employment/updateEmployment2" method="post">
            <ul id="u1">
                <li>公司名</li>
                <li><input name="EM_COMPANY" class="ins" msg="公司名" type="text" value="${requestScope.employment.getEM_COMPANY()}"></li>
                <li>岗位</li>
                <li><input name="EM_POST" class="ins" msg="岗位" type="text" value="${requestScope.employment.getEM_POST()}"></li>
                <li>需求人数</li>
                <li><input name="EM_PEOPLE" class="ins" msg="需求人数"type="text" value="${requestScope.employment.getEM_PEOPLE()}"></li>
                <li>地址</li>
                <li><input name="EM_ADD" class="ins" msg="地址" type="text" value="${requestScope.employment.getEM_ADD()}"></li>
                <li>学历要求</li>
                <li><input name="EM_EDU" class="ins" msg="学历要求" type="text" value="${requestScope.employment.getEM_EDU()}"></li>
                <li>月薪</li>
                <li><input name="EM_SALARY" class="ins" msg="月薪" type="text" value="${requestScope.employment.getEM_SALARY()}"></li>
                <li>工作经验</li>
                <li><input name="EM_EXP" class="ins" msg="工作经验" type="text" value="${requestScope.employment.getEM_EXP()}">
                    <input type="hidden" value="${requestScope.employment.getEM_DATE()}" name="EM_DATE">
                    <input type="hidden" value="${requestScope.employment.getEM_ID()}" name="EM_ID">
                </li>
                <li><input type="submit" id="sub1"></li>
                <li><p>${requestScope.msg}</p></li>
            </ul>
        </form>
    </div>
</c:if>
<c:if test="${requestScope.department!=null}">
    <form action="department/updateDep" method="post">
        <li><input name="D_name" value="${requestScope.department.getD_name()}">
            <input type="submit" value="修改">
            <input name="D_NUM" value="${requestScope.department.getD_NUM()}" type="hidden">
            <input name="D_id" value="${requestScope.department.getD_id()}" type="hidden">
        </li>
    </form>
</c:if>

<c:if test="${requestScope.post!=null}">
    <form action="post/updatePost2" method="post">
        <li><input name="pname" value="${requestScope.post.getPname()}">
            <input type="submit" value="修改">
            <input name="P_NUM" value="${requestScope.post.getP_NUM()}" type="hidden">
            <input name="p_id" value="${requestScope.post.getP_id()}" type="hidden">
        </li>
    </form>
</c:if>

<c:if test="${requestScope.emp!=null}">
  <form action="emp/updateDP2" method="post">
      <p>将${requestScope.emp.getE_realName()}调换至</p>
      <select name="did" id="s1">
          <option value="${null}" >选择部门</option>
          <c:forEach items="${requestScope.departments}" var="i">
              <option name="" value="${i.getD_id()}">${i.getD_name()}</option>
          </c:forEach>
      </select>
      <select name="pid" id="s2">
          <option value="${null}" >选择岗位</option>
      </select>
      <input type="hidden" value="${requestScope.emp.getE_id()}" name="eid">
      <input type="hidden" value="${requestScope.emp.getE_d_id()}" name="odid">
      <input type="hidden" value="${requestScope.emp.getE_p_id()}" name="opid">
      <p><input type="submit"></p>
  </form>
</c:if>
<c:if test="${requestScope.empDis!=null}">
    <p>${requestScope.msg}</p>
    <form action="emp/doDismission" method="post">
        离职原因:<input name="dm_result"><input name="dm_e_id" type="hidden" value="${requestScope.empDis}">
        <input type="submit" name="" id="">
    </form>
</c:if>
</body>
<script>
    $(function () {
        $("#s1").change(function () {
            $.ajax({
                type:"get",
                url:"emp/findPosts",
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
</script>
</html>
