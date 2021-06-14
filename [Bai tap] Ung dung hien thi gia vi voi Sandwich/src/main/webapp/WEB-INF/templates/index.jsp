<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 6/14/2021
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div style="text-align: center">
    <h1>Sandwich Condiments</h1>
    <form method="post">
      <p style="color: red">${message}</p><br/>
      <input type="checkbox" name = "condiments" value="Lettuce">Lettuce
      <input type="checkbox" name = "condiments" value="Tomato">Tomato
      <input type="checkbox" name = "condiments" value="Mustard">Mustard
      <input type="checkbox" name = "condiments" value="Sprouts">Sprouts
      <br/>
      <input type = "submit" value = "Save" style="margin-top: 30px">
    </form>
  </div>

  </body>
</html>
