<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<s:iterator value="merchandiseList">

    <tr>
        <td><s:property value="goodsName" />
        </td>
        <td><s:property value="goodsId" />
        <td><s:property value="goodsId" />
        </td>
        <td><s:property value="origin" />
        </td>
                        <td><s:property value="apath" />
    </td>
    </tr>
</s:iterator>
</body>
</html>