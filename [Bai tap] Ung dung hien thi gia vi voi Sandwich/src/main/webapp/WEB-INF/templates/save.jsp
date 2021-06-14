<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 6/14/2021
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <h3>SELECTED</h3>
    <c:forEach var="c" items="${requestScope.condiment}">
        <p style="text-align: center">${c}</p>
    </c:forEach>
</div>
</body>
</html>
