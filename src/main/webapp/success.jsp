<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<form method="post" action="/comment/addComment">
    <%--需要user信息--上一步提供 addObject(order)--%>
    <%--更新订单状态,物流状态--%>
    账号：<input name="accountId" type="text" value="${order.accountId}"><br/>
    尊敬的顾客,你购买的商品信息如下:<br/>
        商品名称:<input name="goodsName" type="text" value="${order.goodsName}"><br>
        商品ID:<input name="goodsId" type="text" accept="${order.goodsId}"><br/>
    流水号：<input name="busId" type="text" value="${order.busId}"><br/>
    <%--显示文本，传输数字--%>
    <%--订单状态：<input name="order" type="text" value="已下单">--%>
    订单状态：已下单<br/>
        <input name="orderStatus" type="hidden" value="1">
    物流状态：正在派送<br/>
        <input name="transportStatus" type="hidden" value="1">
    <%--评论填写???--%>
    <input type="text" name="commentText" class="form-control" value="请输入您的评论" onblur="if (this.value == '') {this.value = '请输入地址';}" onfocus="if(this.value == 'Your Name') {this.value = '';}">
    <input name="Submit" type="submit" value="提交评论">

    <%--<a href="index.jsp"><input type="submit"  value="返回首页"/></a>--%>



</form>




</body>
</html>
