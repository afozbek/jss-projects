<%--
  Created by IntelliJ IDEA.
  User: furka
  Date: 10.07.2019
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../css/form-elements.css" rel="stylesheet"/>
    <title>Your contacts will be here.</title>
</head>
<body>
<div>
    <h1>Your contacts</h1>
    <div>
        <table>
            <tr>
                <th style="text-align: center;">ID</th>
                <th style="text-align: center;">Name</th>
                <th style="text-align: center;">Email</th>
                <th style="text-align: center;">Phone</th>
                <th style="text-align: center;">Operation</th>
            </tr>
            <%--Update'ler id üzerinden olucak--%>
            <c:forEach var="contact" items="${contactList}">
                <tr>
                    <td style="text-align: center;"><c:out value="${contact.getId()}"/></td>
                    <td><c:out value="${contact.getName()}"/></td>
                    <td><c:out value="${contact.getEmail()}"/></td>
                    <td><c:out value="${contact.getPhone()}"/></td>
                    <td class="table-ops">
                        <span class="table-ops-item"><a href="/update-contact?id=${contact.getId()}">UPDATE</a></span>
                        <span class="table-ops-item"><a href="/delete-contact?id=${contact.getId()}">DELETE</a></span>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="/add-contact" style="margin-top: 30px;">To add contact</a>
</div>
</body>
</html>
