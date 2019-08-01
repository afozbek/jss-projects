<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 11.07.2019
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>${message}</h1>
<div>
    <form action="/LoginServlet" method="post">
        <label for="name">
            Your name:
            <input id="name" name="name" type="text" placeholder="Please enter your name"/>
        </label>
        <br>
        <label for="password">
            Your password:
            <input id="password" name="password" type="password" placeholder="password"/>
        </label>
        <input type="submit" value="SUBMIT"/>
    </form>
</div>
</body>
</html>
