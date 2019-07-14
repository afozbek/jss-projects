<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 14.07.2019
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/form-elements.css" rel="stylesheet" />
    <title>Update Contact</title>
</head>
<body>
<div class="container">
    <form class="form" action="/update-contact" method="post">
        <div class="inner-container">
            <h1 class="header">Update Contact Form</h1>
            <label for="name" class="form-label">
                <span class="form-label-text">Name:</span>
                <input class="form-text form-label-input" id="name" type="text" name="name" value="${name}" required/>
            </label>
            <label for="email" class="form-label">
                <span class="form-label-text">Email: </span>
                <input class="form-text" id="email" type="email" name="email" value="${email}" required/>
            </label>
            <label for="phone" class="form-label">
                <span class="form-label-text">Phone: </span>
                <input class="form-text" id="phone" type="text" name="phone" value="${phone}" required/>
            </label>
            <input class="button" type="submit" value="UPDATE CONTACT">
        </div>
        <input type="hidden" name="id" value="${id}" />
    </form>
    <a href="/contacts" style="background: none; color: #f13273; margin:20px auto;">To see your contacts</a>
</div>
<input type="hidden" name="id" value="${id}" />
</body>
</html>
