<%@page import="kr.multicampus.erp.user.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="/layout/servlet_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<%
				ArrayList<EmpDTO> empList = (ArrayList<EmpDTO>) request.getAttribute("empList");
				%>
				<table width=800 border=1>
					<tr>
						<th>부서번호</th>
						<th>성명</th>
						<th>사번</th>
						<th>패스워드</th>
						<th>주소</th>
						<th>포인트</th>
						<th>등급</th>
						<th>삭제</th>
					</tr>
					<%
					for (int i = 0; i < empList.size(); i++) {
						EmpDTO emp = empList.get(i);
					%>
					<tr>
						<td><%=emp.getDeptno()%></td>
						<td><%=emp.getName()%></td> 
						<td><a href="/serverweb/mvc/read.do?id=<%= emp.getId()%>"><%=emp.getId()%></a></td>
						<td><%=emp.getPass()%></td>
						<td><%=emp.getAddr()%></td>
						<td><%=emp.getPoint()%></td>
						<td><%=emp.getGrade()%></td>
						<td><a href="/serverweb/mvc/delete.do?id=<%=emp.getId()%>">삭제</a></td>
						<%-- <td><a href="/serverweb/emp/delete.do?test=info&id=<%=emp.getId()%>">삭제</a></td> --%>
					</tr>
					<% } %>
				</table>
			</div>
		</div>
	</div>
</body>
</html>