<%@page import="kr.multicampus.erp.board.BoardDTO"%>
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
				<jsp:include page="/layout/board_menu.jsp" />
			</div>
			<div class="col-lg-10">
				<%
					ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) request.getAttribute("boardList");
				%>
				<table width=800 border=1>
					<tr>
						<th>게시글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>삭제</th>
					</tr>
					<%
						for (int i = 0; i < boardList.size(); i++) {
							BoardDTO board = boardList.get(i);
					%>
					<tr>
						<td><%= board.getBoardNo() %></td> 
						<td><a href="/serverweb/board/read.do?boardNo=<%= board.getBoardNo()%>"><%=board.getTitle()%></a></td>
						<td><%= board.getWriter() %></td>
						<td><%= board.getWriteDate() %></td>
						<td><a href="#">삭제</a></td>
					</tr>
					<% } %>
				</table>
			</div>
		</div>
	</div>
</body>
</html>