package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "empInsert", urlPatterns = {"/emp/insert.do"})
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
		
		EmpDTO emp = new EmpDTO(deptno, name, id, pass, addr, grade);
		EmpDAO empDAO = new EmpDAOImpl();

		// 2. 비지니스 로직 메소드 호출
		// 서블릿에서 바로 응답화면을 만들지 않고 응답할 뷰를 지정해서 실행되도록 처리
		String view = "";	// 응답할 뷰에 대한 정보
		if(empDAO.insert(emp) == 0) {	// 삽입 실패
//			out.write("<h1>사원등록실패</h1>");
			view = "/serverweb/user/insertFail.html";
		}else {							// 삽입성공
//			out.write("<h1>사원등록성공</h1>");
			view = "/serverweb/user/insertOk.html";
		}
		// 응답뷰가 클라이언트에게 response 되도록 재요청
		resp.sendRedirect(view);
		
	}
}
