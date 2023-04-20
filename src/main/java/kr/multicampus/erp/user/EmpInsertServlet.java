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
		if(empDAO.insert(emp) == 0) {
			out.write("<h1>사원등록실패</h1>");
		}else {
			out.write("<h1>사원등록성공</h1>");
		}
		
	}
}
