<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 6/11/2021
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dictionary</h2>
<form method="get" action="/dictionary">
    <label>Search: </label><br/>
    <input type="text" name="word_1" /><br/>
    <label>Result: </label><br/>
    <input type="text" name="result" value="${result}"/><br/>
    <input type="submit" id="submit" style="margin-top: 10px" value="Search"/>
</form>
</body>
</html>
