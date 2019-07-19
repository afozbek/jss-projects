<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <%--    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>--%>

    <spring:url value="/resources/css/style.css" var="styleCSS"/>

    <link href="${styleCSS}" rel="stylesheet"/>
    <title>Index Page</title>
</head>
<body>
<div class="container">
    <h1>Hello from Maven - Index Page</h1>
    <h2>You have some messages: ${message}</h2>
</div>
</body>
</html>
