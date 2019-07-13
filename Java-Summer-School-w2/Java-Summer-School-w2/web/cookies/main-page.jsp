<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%! String favoriteLanguage; %>
<body>
	<%
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("favoriteLanguage")) {
					favoriteLanguage = cookie.getValue();
				}
			}
		}
	%>
	Your favorite language is <%= favoriteLanguage %><br>
	Here are some resources for the programming language <%= favoriteLanguage %>:<br>
	....<br>
	....<br>
</body>
</html>