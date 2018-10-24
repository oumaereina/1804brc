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
<head>
    <base href="<%=basePath%>"/>
    <title>管理员</title>
</head>
<body>
<div>
    <ul>
        <li>您有${requestScope.noReadResumes}条未读简历</li>
    </ul>
</div>
<div>
    <ul>
        <li><a href="admin/showMsg">消息</a></li>
        <li><a href="resume/selectAllResumeAdmin">游客简历管理</a></li>
        <li><a href="pages/adminEmployment.jsp">招聘信息管理</a></li>
        <li><a href="department/showDep">部门管理</a></li>
    </ul>
</div>
<c:if test="${requestScope.visitors!=null}">
    <div>
       <c:forEach items="${requestScope.visitors}" var="i">
           <ul>
               <li>游客 ${i.getV_name()} 已确认面试邀请,请及时联系并考虑是否录取<a href="emp/addEmp?vid=">录用此人</a></li>
           </ul>
       </c:forEach>
    </div>
</c:if>
</body>
</html>
