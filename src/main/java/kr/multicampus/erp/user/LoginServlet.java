package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.CustomerVO;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// 1. 요청정보 추출
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		// 2. 비지니스 로직 메소드 호출
		CustomerDAO userObj = new CustomerDAOImpl();
		CustomerVO user = userObj.login(id, pass);
		
		if(user != null) {
			out.write("<h1>로그인 성공!</h1>");
		}else {
			out.write("<h1>로그인 실패!</h1>");
		}
	}
}
