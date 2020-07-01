<%@ page language="java" contentType="text/html; charset=UTF-8"
                pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品搜索</title>
</head>
<body>
<h3>商品搜索</h3>
<form method="post" action="merchandise/merchandiseInfor">
    <%--<form method="post" action="merchandiseInfor.jsp">--%>
    请输入商品的名字或生产地<br>
    产地：<input name="origin" type="text"><br>
    名称：<input name="goodsName" type="text">
    <input type="submit" value="搜索">
</form>
</body>
</html>