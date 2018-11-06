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
            <td width="100"><input name="r_name" class="tr" msg="姓名"></td>
            <td width="89">出生日期:</td>
            <td width="113"><input type="date" name="r_bir" class="tr" msg="生日"></td>
            <td width="91">性别:</td>
            <td width="48"><input name="r_sex" class="tr" msg="性别"></td>
            <td width="121" rowspan="5" background=""></td>
        </tr>
        <tr>
            <td>身份证:</td>
            <td><input name="r_idc" class="tr" msg="身份证"></td>
            <td>户口:</td>
            <td><input name="r_native_place" class="tr" msg="户口"></td>
            <td>毕业院校:</td>
            <td><input name="r_school" class="tr" msg="学校"> </td>
        </tr>
        <tr>
            <td>学历:</td>
            <td><input name="r_edu" class="tr" msg="学历"></td>
            <td>身高:</td>
            <td><input name="r_height" class="tr" msg="身高"></td>
            <td>体重:</td>
            <td><input name="r_weight" class="tr" msg="体重"></td>
        </tr>
        <tr>
            <td>专业:</td>
            <td><input name="r_major" class="tr"  msg="专业"></td>
            <td>民族:</td>
            <td><input name="r_nation" class="tr" msg="民族"></td>
            <td>政治面貌</td>
            <td><input name="r_pol_sta" class="tr" msg="政治面貌"></td>
        </tr>
        <tr>
            <td height="24" colspan="2">家庭住址:</td>
            <td colspan="4"><input name="r_add" class="tr" msg="家庭住址"></td>
        </tr>
        <tr>
            <td>手机号码:</td>
            <td colspan="2"><input name="r_phone" class="tr" type="number" msg="手机"></td>
            <td>个人主页:</td>
            <td colspan="3"><input disabled></td>
        </tr>
        <tr>
            <td>固定电话:</td>
            <td colspan="2"><input disabled></td>
            <td>电子信箱:</td>
            <td colspan="3"><input name="r_health" class="tr" msg="邮箱"></td>
        </tr>
        <tr>
            <td>英语水平/等级:</td>
            <td colspan="6"><input name="r_english" class="tr" msg="英语水平"></td>
        </tr>
        <tr>
            <td colspan="7" align="center"><b>工作经历&自我评价(不超过500字)</b></td>
        </tr>
        <tr>
            <td colspan="7" height="500">
                <textarea name="r_self" style="width: 500px;height: 300px" msg="自我评价" class="tr"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="7" align="center"><b>求职意向</b></td>
        </tr>
        <tr><td colspan="6"><input name="r_hobby" class="tr" msg="求职意向">
            <input type="hidden" name="r_vid" value="${sessionScope.visitor.getV_id()}">
        </td></tr>
        <tr><td><input type="submit" id="sub2"></td></tr>
    </table>
</form>
</body>
<script>
    $(function () {
        $("#sub2").click(function (e) {
            var num=0;
            var str="";
            $(".tr").each(function(n){
                if($(".tr").val()=="")
                {
                    num++;
                    str+=$(this).attr("msg")+"不能为空！\r\n";
                }
            });
            if(num>0)
            {
                alert(str);
                e.preventDefault()
                return false;
            }

        })
    })
</script>
</html>
