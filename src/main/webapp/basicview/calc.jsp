<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/serverweb/calc.do">
		<input type="text" name="num1"/>
		<select name="method">
			<option value="+">+
			<option value="-">-
			<option value="*">*
			<option value="/">/
		</select>
		<input type="text" name="num2"/>
		<input type="submit" value="ì ì¡"/>
	</form>
</body>
</html>
