<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/23
  Time: 23:10
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
    <title>游客简历管理</title>
</head>
<style>
    .uu{
        font-size: 14px;
        list-style-type: none;
    }
    #u1{
        font-size: 14px;
        list-style-type: none;
    }
</style>
<body>
<div>
    <ul id="u1">
        <li><a href="resume/selectResume">查看简历</a></li>
        <li><a href="">修改简历</a></li>
    </ul>
</div>
<form action="resume/updateResume" method="post">
    <div>
       <c:forEach var="i" items="${sessionScope.resumes}">
           <ul class="uu">
               <li><input type="text" value="${i.getR_name()}" name="r_name"></li>
               <li><input type="text"value="${i.getR_sex()}" name="r_sex"></li>
               <li><input type="text"value="${i.getR_nation()}" name="r_nation"></li>
               <li><input type="text"value="${i.getR_bir()}" name="r_bir"></li>
               <li><input type="text"value="${i.getR_native_place()}" name="r_native_place"></li>
               <li><input type="text"value="${i.getR_pol_sta()}" name="r_pol_sta"></li>
               <li><input type="text"value="${i.getR_height()}" name="r_height"></li>
               <li><input type="text"value="${i.getR_weight()}" name="r_weight"></li>
               <li><input type="text"value="${i.getR_english()}" name="r_english"></li>
               <li><input type="text"value="${i.getR_edu()}" name="r_edu"></li>
               <li><input type="text"value="${i.getR_major()}" name="r_major"></li>
               <li><input type="text"value="${i.getR_idc()}" name="r_idc"></li>
               <li><input type="text"value="${i.getR_phone()}" name="r_phone"></li>
               <li><input type="text"value="${i.getR_add()}" name="r_add"></li>
               <li><input type="text"value="${i.getR_school()}" name="r_school"></li>
               <li><input type="text"value="${i.getR_hobby()}" name="r_hobby"></li>
               <li><input type="text"value="${i.getR_self()}" name="r_self">
                   <input type="hidden" value="${i.getR_id()}" name="r_id">
               </li>
               <c:if test="${i.getR_state()==1}">
                   <li>已读</li>
               </c:if>
               <c:if test="${i.getR_state()==0}">
                   <li>未读</li>
               </c:if>
               <li><input type="submit" value="修改"></li>
           </ul>
       </c:forEach>
    </div>
</form>
</body>
</html>
