<%@page import="kr.multicampus.erp.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<%	BoardDTO board = (BoardDTO) request.getAttribute("board"); %>
	<jsp:include page="../top.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 sidenav">
				<jsp:include page="/layout/board_menu.jsp" />
			</div>
			<form role="form" class="form-horizontal" action="" method="get">
				<fieldset>
					<div id="legend">
						<legend>아래 양식을 작성해주세요.</legend>
					</div>
					<div class="form-group">
						<!-- 게시글번호 -->
						<label class="control-label col-sm-2" for="deptcode">게시글번호</label>
						<div class="col-sm-3">
							<%= board.getBoardNo() %>
						</div>
					</div>

					<div class="form-group">
						<!-- 제목 -->
						<label class="control-label col-sm-2" for="addr">제목</label>
						<div class="col-sm-3">
							<!-- 제목을 이곳에 출력하세요 -->
							<%= board.getTitle() %>
						</div>
					</div>

					<div class="form-group">
						<!-- 부서명-->
						<label class="control-label col-sm-2" for="name">작성자</label>
						<div class="col-sm-3">
							<!-- 작성자를 이곳에 출력하세요 -->
							<%= board.getWriter() %>
						</div>
					</div>
					<div class="form-group">
						<!-- 아이디-->
						<label class="control-label col-sm-2" for="id">작성일자</label>
						<div class="col-sm-3">
							<!-- 작성일자를 이곳에 출력하세요 -->
							<%= board.getWriteDate() %>
						</div>
					</div>

					<div class="form-group">
						<!-- 입사날짜-->
						<label class="control-label col-sm-2" for="hiredate">내용</label>
						<div class="col-sm-3">
							<!-- 내용을 이곳에 출력하세요 -->
							<%= board.getContent() %>
						</div>
					</div>
					
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="button" value="수정" class="btn btn-success" />
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	</div>
</body>
</html>