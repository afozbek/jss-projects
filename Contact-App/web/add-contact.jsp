<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 10.07.2019
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add-Contact</title>
</head>
<style>
    .form-label {
        margin: 5px 0;
    }
    .button {
        width: ;
    }
</style>
<body style="display: flex;
    justify-content: center;
    align-items: center;
    background-color: aqua;">
<div>
    <form action="/contact" method="post"
          style="display: flex; flex-direction: column;
            justify-content: center;
            align-items: center;">
        <label for="name" class="form-label">
            Name:
            <input id="name" type="text" name="name"  required />
        </label>
        <label  for="email" class="form-label">
            Email:
            <input id="email" type="email" name="email"  required/>
        </label>
        <label for="phone" class="form-label">
            Phone:
            <input id="phone" type="text" name="phone" required/>
        </label>
        <input type="submit" value="POST CONTACT" style="min-width: 56%;">
    </form>
</div>
</body>
</html>
