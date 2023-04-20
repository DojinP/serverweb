package kr.multicampus.erp.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "empdelete", urlPatterns = { "/emp/delete.do" })
public class EmpDeleteServlet extends HttpServlet {
	// 송신하기 위해 만들어진 것
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청정보 추출
//		String test = request.getParameter("test");
		String id = request.getParameter("id");
//		System.out.println(test+":"+id);
		
		EmpDAO empDAO = new EmpDAOImpl();
		
		// 비지니스 메소드 호출
		int result = empDAO.delete(id);
		
		// 응답생성
		String redi = "";
		if(result > 0) {
			redi = "/serverweb/user/deleteOK.html";
		}else {
			redi = "/serverweb/user/deleteFail.html";
		}
		
		response.sendRedirect(redi);
	}

}
