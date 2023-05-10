package kr.multicampus.erp.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet(name = "BoardList", urlPatterns = { "/board/list.do" })
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 요청정보 추출
		
		// 비즈니스 로직 메소드 콜
		BoardDAO dao = new BoardDAOImpl();
		ArrayList<BoardDTO> boardList = dao.select();
		
		// 데이터 공유
		request.setAttribute("boardList", boardList);
		
		// 요청재지정
		String path = "/board/board_list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
