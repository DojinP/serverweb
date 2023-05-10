package kr.multicampus.erp.user.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "logout", urlPatterns = { "/logout.do" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 하이퍼링크 접근은 Get 방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getSession(boolean)
		/*
		 *  -> 기존에 작업하는 세션이 있는지 확인하고 세션객체를 반환
		 *   getSession(true) - getSession()과 동일
		 *   getSession(false) - 기존에 사용하던 세션이 있으면 세션 객체를 반환, 없다면 null을 반환
		 *   
		 */
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			// 사용하던 세션을 메모리에서 해제
			session.invalidate();
		}
		
		String path = "/serverweb/index.jsp";
				
		response.sendRedirect(path);
	}

}
