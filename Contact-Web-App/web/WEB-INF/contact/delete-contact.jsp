<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 15.07.2019
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../css/form-elements.css" rel="stylesheet"/>
    <title>Delete a Contact</title>
</head>
<body>
<div class="container">
    <form class="form" action="/delete-contact" method="post">
        <div class="inner-container">
            <h1 class="header">You really sure😒?</h1>
            <label class="form-label" for="contactId">
                <span class="form-label-text">Contact ID:</span>
                <input class="form-text form-label-input" id="contactId" type="text" name="contactId" value="${id}"
                       required/>
            </label>
            <input class="button" type="submit" value="DELETE CONTACT">
        </div>
        <input type="hidden" name="id" value="${id}"/>
    </form>
    <a href="/contacts">I Change My Mind 😂</a>
</div>
</body>
</html>
