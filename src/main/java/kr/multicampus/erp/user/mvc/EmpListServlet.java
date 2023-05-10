package kr.multicampus.erp.user.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name = "emplist_mvc",urlPatterns = {"/mvc/list.do"})
public class EmpListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 인코딩 등 설정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// DAO 객체 생성
		EmpDAO empDAO = new EmpDAOImpl();
		ArrayList<EmpDTO> empList = null;
		
		// 비지니스 로직 메소드 호출
		empList = empDAO.select();
		
		req.setAttribute("empList", empList);
		
		RequestDispatcher rd = req.getRequestDispatcher("/user_mvc/list.jsp");
		rd.forward(req, resp);
	}
}
