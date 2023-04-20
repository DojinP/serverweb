<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- String 타입으로 id 변수를 정의한 후 값을 임의로 할당 
		if문을 이용해서 id가 "java"인지 확인 
		id가 "java"이면 bts.jpg를 출력
		아니면 bts2.jpg를 출력
	-->
	<%!
		String id = "java";
		/* String id = "test"; */
	%>
	
	<% 
		if(id == "java"){
	%>
			<img src="/serverweb/images/bts.jpg" width=200>
	<%
		}else{
	%>
			<img src="/serverweb/images/jang1.jpg" width=200>
	<%
		}
	%>
</body>
</html>