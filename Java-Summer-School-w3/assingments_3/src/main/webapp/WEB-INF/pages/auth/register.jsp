<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:url value="/resources/css/style.css" var="styleCSS"/>

    <link href="${styleCSS}" rel="stylesheet"/>
    <title>Registration Form</title>
</head>
<body>
<div class="container">
    <form class="form" action="/register" method="post">
        <div class="inner-container">
            <h1 class="header">Register Page</h1>
            <div class="form-input">
                <label for="username" class="form-label">
                    <span class="form-label-text">Name:</span>
                    <input class="form-text form-label-input" id="username" type="text" name="username" required/>
                </label>
            </div>
            <div class="form-input">
                <label for="email" class="form-label">
                    <span class="form-label-text">Email: </span>
                    <input class="form-text" id="email" type="email" name="email" required/>
                </label>
            </div>
            <div class="form-input">
                <label for="birthday" class="form-label">
                    <span class="form-label-text">Birthday: </span>
                    <input class="form-text" id="birthday" type="date" name="birthday" required/>
                </label>
            </div>
            <div class="form-input">
                <label class="form-label">
                    <span class="form-label-text">Sex: </span>
                    <span class="sex-wrapper">
                    <label for="male" class="inline-label">
                        <span class="form-label-radio">Male: </span>
                        <input class="form-radio" id="male" type="radio" name="sex" checked/>
                    </label>
                    <label for="female" class="inline-label">
                        <span class="form-label-radio">Female: </span>
                        <input class="form-radio" id="female" type="radio" name="sex"/>
                    </label>
                </span>
                </label>
            </div>

            <div class="form-input">
                <label for="password" class="form-label">
                    <span class="form-label-text">Password: </span>
                    <input class="form-text" id="password" type="password" name="password" required/>
                </label>
            </div>

            <%--            <label for="password-confirm" class="form-label">--%>
            <%--                <span class="form-label-text">Confirm Your Password: </span>--%>
            <%--                <input class="form-text" id="password-confirm" type="password" name="password-confirm" required/>--%>
            <%--            </label>--%>
            <input class="button" type="submit" value="POST CONTACT">
        </div>
    </form>
    <a href="/">Go To Index Page</a>
</div>
</body>
</html>
