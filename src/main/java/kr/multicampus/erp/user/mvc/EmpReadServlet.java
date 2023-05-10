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

@WebServlet(name = "empRead_mvc",urlPatterns = {"/mvc/read.do"})
public class EmpReadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서블릿에서 응답데이터에 대한 한글처리는 하지 않아도 된다.
		// 응답을 jsp 로 분리했으므로 jsp에서 한글처리를 하면 된다.
		// 인코딩 등 설정
		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = resp.getWriter();
		
		// 요청정보 추출
		String id = req.getParameter("id");
		System.out.println(id);
		EmpDTO emp = null;
		EmpDAO dao = new EmpDAOImpl();
		
		// 비지니스 메소드 call
		emp = dao.read(id);
		
		// 데이터 공유
		req.setAttribute("emp", emp);
		
		// 요청재지정
		RequestDispatcher rd = req.getRequestDispatcher("/user_mvc/emp_read.jsp");
		rd.forward(req, resp);
	}
}
