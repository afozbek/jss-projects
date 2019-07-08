<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 8.07.2019
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
    <table style="width:100%">
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Age</th>
        </tr>
        <tr>
            <td><%=request.getParameter("name")%></td>
            <td><%=request.getParameter("lastName")%></td>
            <td><%=request.getParameter("age")%></td>
        </tr>
    </table>
</body>
</html>
