<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--<c:forEach items="${merchandiseList}" var="merchandise">--%>
    <%--<tr>--%>
        <%--<td>${merchandise.id}</td>--%>
        <%--<td>${merchandise.goodsId}</td>--%>
        <%--<td>${merchandise.goodsName}</td>--%>
        <%--<td>${merchandise.inventory}</td>--%>
        <%--<td>${merchandise.describe}</td>--%>
        <%--<td>${merchandise.origin}</td>--%>
    <%--</tr>--%>
<%--</c:forEach>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品信息</title>
</head>
<body>
<h3>商品信息</h3>
<form method="post" action="index.jsp">
    <%--<form method="post" action="merchandiseInfor.jsp">--%>
    商品名称：
    <input name="goodsName" type="text" value="${merchandise.goodsName}"><br>
        商品详情：
    <input name="describe" type="text" value="${merchandise.describe}"><br>
        商品价格：
    <input name="goodsPrice" type="text" value="${merchandise.goodsPrice}"><br>
        商品库存：
    <input name="inventory" type="text" value="${merchandise.inventory}"><br>
        商品购买量：
    <input name="purchaseCount" type="text" value="${merchandise.purchaseCount}">
        商品可积分：
    <input name="score" type="text" value="${merchandise.score}"><br>
        商品产地：
    <input name="origin" type="text" value="${merchandise.origin}"><br>

    <input type="submit" value="返回">
</form>
</body>
</html>