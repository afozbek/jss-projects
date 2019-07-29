<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 11.07.2019
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cookies</title>
</head>
<body>
<h1>You can see your cookies</h1>
<div>
    <h1>You have ${cookieNumber} of cookies</h1>

    <c:forEach items="${cookies}" var="cookie">
        <li>${cookie.getValue()}</li>
    </c:forEach>
</div>
</body>
</html>
