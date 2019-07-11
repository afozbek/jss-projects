<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 9.07.2019
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Atm</title>
</head>
<body>
<form action="/AtmServlet" method="post">
    <label for="operation">
        <input id="operation" type="text" name="operation" value="WITHDRAW">
    </label>
    <label for="amount">
        <input id="amount" type="text" name="amount" value="15">
    </label>
    <input type="submit" value="Submit">
</form>
</body>
</html>
