<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <table style="width:100%">
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Age</th>
        </tr>
        <tr>
            <td><%request.getParameter("name");%></td>
            <td><%request.getParameter("lastName");%></td>
            <td><%request.getParameter("age");%></td>
        </tr>
    </table>

    <a href="ParameterServlet">Go to Servlet</a>
</body>
</html>
