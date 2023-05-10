package kr.multicampus.erp.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BoardInsert", urlPatterns = { "/board/write.do" })
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 요청정보 추출
		String writer = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// 비즈니스 로직 메소드 콜
		BoardDAO dao = new BoardDAOImpl();
		BoardDTO board = new BoardDTO(0, title, writer, content, null);
		int result = dao.insert(board);

		// 데이터 공유
//		아래 코드는 sendRedirect 되므로 의미가 없다.		
//		request.setAttribute("board", board);

		// 요청재지정
		String path = "";
		if (result > 0) {
			path = "/serverweb/board/list.do";
//			response.sendRedirect(path);
		} else {	// 테스트 필요 04/24 16:21
//			path = "/board/write.do";
//			RequestDispatcher rd = request.getRequestDispatcher(path);
//			rd.forward(request, response);
			path = "/serverweb/board/board_write.jsp";
		}
		response.sendRedirect(path);
		
		
	}

}
