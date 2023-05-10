<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		table{
			font-size: 20pt;
		}
	</style>
</head>
<body>
	<table border='1' width='800'>
	<% 
		for(int i=1; i<=9; i++){
			%><tr><% 
			for(int j=1; j<=9; j++){
				if(i==j){	%>
					<th> <img src="../images/flower1.png"> </th>
				<%}else{%>
				<th><%=i+"*"+j+"="+(i*j)%></th>			
				<%}
			}
		}%>
	</table>
</body>
</html>