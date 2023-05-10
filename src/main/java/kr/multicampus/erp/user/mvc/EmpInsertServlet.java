package kr.multicampus.erp.user.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name = "empInsert_mvc", urlPatterns = {"/mvc/insert.do"})
public class EmpInsertServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// 1. 요청정보 추출
		String deptno = req.getParameter("deptno");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String addr = req.getParameter("addr");
		int point = Integer.parseInt(req.getParameter("point"));
		String grade = req.getParameter("grade");

		// 2. 비지니스 로직 메소드 호출
		EmpDTO emp = new EmpDTO(deptno, name, id, pass, addr, grade);
		EmpDAO empDAO = new EmpDAOImpl();
		int result = empDAO.insert(emp);

		// 3. 데이터 공유
		req.setAttribute("insertuser", name);

		// 4. 요청 재지정
		// 서블릿에서 바로 응답화면을 만들지 않고 응답할 뷰를 지정해서 실행되도록 처리
		String view = "";	// 응답할 뷰에 대한 정보
		if(result > 0) {	
			// 이미 요청 scope 내부에서 처리중이므로 context path는 생략
			view = "/user_mvc/insertOK.jsp";
		}else {				
			view = "/user_mvc/insertFail.jsp";
		}
		// 응답뷰가 클라이언트에게 response 되도록 재요청
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
		
	}
}
