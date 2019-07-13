<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 10.07.2019
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="../css/form-elements.css"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add-Contact</title>
</head>
<body style="font-family: monospace; display: flex; justify-content: center; align-items: center; background-color: #000000ed;">
<div class="container">
    <form class="form" action="/add-contact" method="post">
        <div class="inner-container">
            <h1 class="header">Contact Form</h1>
            <label for="name" class="form-label">
                <span class="form-label-text">Name:</span>
                <input class="form-text form-label-input" id="name" type="text" name="name" required/>
            </label>
            <label for="email" class="form-label">
                <span class="form-label-text">Email: </span>
                <input class="form-text" id="email" type="email" name="email" required/>
            </label>
            <label for="phone" class="form-label">
                <span class="form-label-text">Phone: </span>
                <input class="form-text" id="phone" type="text" name="phone" required/>
            </label>
            <input class="button" type="submit" value="POST CONTACT">
        </div>
    </form>
    <a href="/contacts" style="background: none; color: #f13273; margin:20px auto;">To see your contacts</a>
</div>
</body>
</html>
