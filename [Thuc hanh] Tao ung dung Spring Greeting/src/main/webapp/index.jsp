<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 6/11/2021
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<h2>Currency Converter</h2>
<form method="get" action="/currency">
    <label>Rate: </label><br/>
    <input type="number" name="rate" placeholder="RATE" value="0"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="result" /><br/>
    <input type="submit" id="submit" style="margin-top: 10px" />
</form>
</body>
</html>
