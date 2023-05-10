package kr.multicampus.erp.user.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "empLogin", urlPatterns = { "/mvc/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 요청정보 추출하기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// 비지니스 메소드 호출
		EmpDAO dao = new EmpDAOImpl();
		EmpDTO emp = dao.login(id, pass);
		
		// 데이터 공유 - 사이트를 이용하는 동안 유지되어야 하는 데이터는 세션 객체에 저장 (로그인 정보)
		/*
		 * 1. 세션 객체 생성 
		 * 	1) getSession() 
		 * 		- request에서 세션id를 꺼내고 서버에 할당된 세션의 세션id와 일치하는 것이 없거나 
		 * 		  세션id가 존재하지 않으면 세션을 HttpSession 객체로 만들어 리턴한다. 
		 * 		- 일치하는 세션id가 있으면 그 세션id로 정의된 세션을 HttpSession 객체로 만들어서 리턴한다. 
		 * 		ex) 로그인 버튼을 눌러서 로그인에 성공하면 세션을 무조건 생성 (일반적) 
		 * 
		 * 	2) getSession(true) - 1번과 동일
		 * 
		 * 	3) getSession(false)
		 * 		- 일치하는 세션id가 존재하면 세션 객체를 만들어 리턴
		 * 		- 일치하는 세션id가 존재하지 않으면 null을 리턴
		 * 
		 * 		ex) 세션유무를 체크하는 경우 사용(로그아웃)
		 * 
		 */ 
		
//		request.setAttribute("emp", emp);
		
		// 요청재지정
		String path = "";
		// 로그인이 성공해야 세션을 생성
		if(emp!=null) {
			HttpSession session = request.getSession(); // 세션 생성
			// 세션에 데이터 공유
			session.setAttribute("emp", emp);
			path = "/index.jsp";
		}else {
			path = "/user_mvc/login.jsp";	
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
