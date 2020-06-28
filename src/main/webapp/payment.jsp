<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<form method="post" action="/transport/addTransport">
    流水号：<input name="busId" type="text" value="${order.busId}"><br/>
    账号：<input name="accountId" type="text" value="${order.accountId}"><br/>
    商品名称：<input name="goodsName" type="text" value="${order.goodsName}"><br/>
    总计价格：<input name="allPrice" type="text" value="${order.allPrice}"><br/>
    手机号码：<input name="phone" type="text" value="${order.phone}"><br/>
    收货地址：<input name="address" type="text" value="${order.address}"><br/>
    <%--支付方式下拉--%>
    支付方式：<input name="pay"> <select name="pay">
         <option value="0">-请选择-</option>
        <option value="1">-支付宝-</option>
        <option value="2">-微信-</option>
        <option value="3">-其他支付-</option>

    </select>
    <%--<br/>--%>
    订单状态：<input name="status" type="text" value="已下单"> <br/>
    创建时间：<input name="createTime" type="text" value="${order.createTime}"> <br/>
    <input name="Submits" type="submit" value="确认订单"/>



    <%--<input type="hidden" name="busId" value="${order.busId}">--%>



    <%--<a href="register.jsp"><input type="button"  value="注册"/></a>--%>

</form>
</body>
</html>