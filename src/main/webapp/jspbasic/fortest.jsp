<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fortest</h1>
	<table border='1' width=200>
	<% 
		for(int i=0; i<10; i++){
	%>
		<tr>
			<td>
				<h1><%= i+1 %></h1>
			</td>
		</tr>
	<%				
		}
	%>
	</table>
</body>
</html>