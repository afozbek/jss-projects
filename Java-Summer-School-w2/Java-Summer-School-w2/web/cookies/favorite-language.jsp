<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CookieServlet" method="post">
		<input type="radio" name="favoriteLanguage" value="Java">Java
		<input type="radio" name="favoriteLanguage" value="C++" />C++
		<input type="radio" name="favoriteLanguage" value="Kotlin" />Kotlin
		<input type="submit" value="submit" />
	</form>
</body>
</html>