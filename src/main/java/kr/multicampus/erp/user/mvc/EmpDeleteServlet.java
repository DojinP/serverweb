package kr.multicampus.erp.user.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;

@WebServlet(name = "empdelete_mvc", urlPatterns = { "/mvc/delete.do" })
public class EmpDeleteServlet extends HttpServlet {
	// 송신하기 위해 만들어진 것
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청정보 추출
		String id = request.getParameter("id");
		
		EmpDAO empDAO = new EmpDAOImpl();
		
		// 비지니스 메소드 호출
		int result = empDAO.delete(id);
		
		// 응답생성
		String redi = "";
		if(result > 0) {
			redi = "/serverweb/mvc/list.do";
		}else {
			redi = "/serverweb/mvc/list.do";
		}
		
		response.sendRedirect(redi);
	}

}
