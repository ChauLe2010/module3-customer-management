<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/2/2020
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/customers?action=create">Create new cutstomer</a>
<c:forEach items="${customers}" var="customer">
    <c:out value="${customer.getId()}"></c:out>
    <c:out value="${customer.getName()}"></c:out>
    <c:out value="${customer.getAddress()}"></c:out>
</c:forEach>
</body>
</html>
