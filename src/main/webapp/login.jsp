<%--
  Created by IntelliJ IDEA.
  User: wangwu
  Date: 2020/6/25
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>login</title>
</head>
<script>

    function checkEmail(){
        var emailifo=$("#email").val();
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/Learn-Spring-MVC/list",
            data: {"listParam" : strList},
            dataType: "json",
            success: function(data){
                var obj=$.parseJSON(data);
                $("#emailMes").html("");
                $("#emailMes").text(obj.warnMsg);
            },
            error:function (data) {
                
            }
        });
    }

</script>

<body>
<%--"/user/toLogin"为submit跳入的方法体--%>
<form method="post" action="/user/toLogin">
    <%--填写的数据为方体所提供，可由HttpServletRequest request接收--%>
    用户名：<input name="accountId" type="text"><br/>
    密码：<input name="password" type="password"> <br/>
    <input name="Submits" type="submit" value="登录"/>
    <input name="ReSet" type="reset" value="重置"/>
        <%--多个submit??--%>
    <a href="register.jsp"><input type="button"  value="注册"/></a>
    <%--<a href="register.jsp"><input type="submit"  value="注册"/></a>--%>

</form>
</body>
</html>
