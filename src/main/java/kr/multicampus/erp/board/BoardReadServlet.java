package kr.multicampus.erp.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BoardRead", urlPatterns = { "/board/read.do" })
public class BoardReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 요청정보 추출
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		// 비즈니스 로직 메소드 call
		BoardDAO dao = new BoardDAOImpl();
		BoardDTO board = dao.read(boardNo);
				
		// 데이터 공유
		request.setAttribute("board", board);
		
		// 요청재지정
		String path = "/board/board_read.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}
