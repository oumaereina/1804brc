<%--
  Created by IntelliJ IDEA.
  User: oumaereina
  Date: 2018/10/20
  Time: 9:33
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
    <title>完成简历</title>
</head>
<script src="js/jquery-3.2.1.js"></script>
<body>
<form action="resume/addResume" method="post" accept-charset="UTF-8">
    <table width="700" height="542" border="0"align="center">
        <caption><h3>个人简历</h3></caption>
        <tr>
            <td width="92">姓名:</td>
            <td width="100"><input name="r_name"></td>
            <td width="89">出生日期:</td>
            <td width="113"><input type="date" name="r_bir"></td>
            <td width="91">性别:</td>
            <td width="48"><input name="r_sex"></td>
            <td width="121" rowspan="5" background=""></td>
        </tr>
        <tr>
            <td>身份证:</td>
            <td><input name="r_idc"></td>
            <td>户口:</td>
            <td><input name="r_native_place"></td>
            <td>毕业院校:</td>
            <td><input name="r_school"></td>
        </tr>
        <tr>
            <td>学历:</td>
            <td><input name="r_edu"></td>
            <td>身高:</td>
            <td><input name="r_height"></td>
            <td>体重:</td>
            <td><input name="r_weight"></td>
        </tr>
        <tr>
            <td>专业:</td>
            <td><input name="r_major"></td>
            <td>民族:</td>
            <td><input name="r_nation"></td>
            <td>政治面貌</td>
            <td><input name="r_pol_sta"></td>
        </tr>
        <tr>
            <td height="24" colspan="2">家庭住址:</td>
            <td colspan="4"><input name="r_add"></td>
        </tr>
        <tr>
            <td>手机号码:</td>
            <td colspan="2"><input name="r_phone"></td>
            <td>个人主页:</td>
            <td colspan="3"><input disabled></td>
        </tr>
        <tr>
            <td>固定电话:</td>
            <td colspan="2"><input disabled></td>
            <td>电子信箱:</td>
            <td colspan="3"><input name="r_health"></td>
        </tr>
        <tr>
            <td>英语水平/等级:</td>
            <td colspan="6"><input name="r_english"></td>
        </tr>
        <tr>
            <td colspan="7" align="center"><b>工作经历&自我评价(不超过500字)</b></td>
        </tr>
        <tr>
            <td colspan="7" height="500">
                <textarea name="r_self" style="width: 500px;height: 300px"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="7" align="center"><b>求职意向</b></td>
        </tr>
        <tr><td colspan="6"><input name="r_hobby">
            <input type="hidden" name="r_vid" value="${sessionScope.visitor.getV_id()}">
        </td></tr>
        <tr><td><input type="submit"></td></tr>
    </table>
</form>
</body>
</html>
