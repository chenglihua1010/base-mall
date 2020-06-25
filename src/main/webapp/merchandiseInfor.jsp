<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${merchandiseList}" var="merchandise">
    <tr>
        <td>${merchandise.id}</td>
        <td>${merchandise.goodsId}</td>
        <td>${merchandise.goodsName}</td>
        <td>${merchandise.inventory}</td>
        <td>${merchandise.describe}</td>
        <td>${merchandise.origin}</td>
    </tr>
</c:forEach>