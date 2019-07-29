<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 11.07.2019
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
<h1>Check Session</h1>
<div>
    <form action="/create-session" method="post">
        <label for="name">
            Your name:
            <input id="name" type="text" value="name"/>
        </label>
        <br>
        <label for="password">
            Your password:
            <input id="password" type="password" value="password"/>
        </label>
        <input type="submit" value="SUBMIT"/>
    </form>
</div>
</body>
</html>
