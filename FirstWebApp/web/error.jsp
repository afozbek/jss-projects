<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 10.07.2019
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h3>Exception Details</h3>
<ul>
    <li><strong>Servlet Name</strong>?=${servletName} </li>
    <li><strong>Status Code</strong>?=${statusCode} </li>
    <%--    <li><strong>Exception Name</strong>?=${exceptionName} </li>--%>
    <%--    <li><strong>Requested URI</strong>?=${requestedURI} </li>--%>
    <%--    <li><strong>Exception Message</strong>?=${exceptionMessage} </li>--%>
</ul>

Click <a id="homeUrl" href="index.jsp">home</a>
</body>
</html>
