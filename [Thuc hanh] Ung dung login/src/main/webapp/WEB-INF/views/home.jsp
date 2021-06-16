<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Home</h3>
<form:form action="login" method="post" modelAttribute="login">
    <tr>
        <td><label for="account">Account: </label></td>
        <td><form:input path="account"></form:input></td>
    </tr><br/>
    <tr>
        <td><label for="password">Password: </label></td>
        <td><form:password path="password"></form:password></td>
    </tr><br/>
    <tr>
        <td></td>
        <td><form:button>Login</form:button></td>
    </tr>

</form:form>
</body>
</html>
