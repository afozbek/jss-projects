<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:url value="/resources/css/style.css" var="styleCSS"/>

    <link href="${styleCSS}" rel="stylesheet"/>
    <title>Login Form</title>
</head>
<body>
<div class="container">
    <form class="form" action="/login" method="post">
        <div class="inner-container">
            <h1 class="header">Login Form</h1>
            <div class="form-input">
                <label for="username" class="form-label">
                    <span class="form-label-text">Username: </span>
                    <input class="form-text form-label-input" id="username" type="text" name="username" required/>
                </label>
            </div>
            <div class="form-input">
                <label for="password" class="form-label">
                    <span class="form-label-text">Password: </span>
                    <input class="form-text" id="password" type="password" name="password" required/>
                </label>
            </div>
            <input class="button" type="submit" value="LOGIN">
        </div>
    </form>
    <a href="/">To Index Page 😉</a>
</div>
</body>
</html>
