<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 6/14/2021
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    input{
      margin-bottom: 20px;
    }
  </style>
</head>

<body>
<div style="margin: auto" >
  <h1>Hieu Calculator</h1>
  <form method="post">

    <input type="number" name="number1" placeholder="Number 1">
    <input type="number" name="number2" placeholder="Number 2"><br/>
    <select name = "method">
      <c:forEach items="${method}" var="method">
        <option value="${method}">
            ${method}
        </option>
      </c:forEach>
    </select>
    <input type = "submit" value = "submit"><br/>
    <p>Result: </p><br/>
    <input type="text" name="result" value="${result}">
  </form>
</div>
</body>
</html>
