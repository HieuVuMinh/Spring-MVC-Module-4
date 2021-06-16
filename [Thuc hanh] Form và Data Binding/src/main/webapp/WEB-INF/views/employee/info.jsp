<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>Name:</td>
        <td>${employee.id}</td>
    </tr>
    <tr>
        <td>ID:</td>
        <td>${employee.name}</td>
    </tr>
    <tr>
        <td>Contact Number:</td>
        <td>${employee.contactNumber}</td>
    </tr>
</table>
</body>
</html>
