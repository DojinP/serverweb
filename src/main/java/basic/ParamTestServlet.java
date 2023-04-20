package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamTestServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청정보에 한글 설정하기(한글 인코딩 적용)
		req.setCharacterEncoding("UTF-8");
		// 1. 응답데이터의 형식과 인코딩 설정
		// 응답정보에 한글 설정하기 - 출력될 응답의 형식을 지정(MIME타입 - text/html)
		resp.setContentType("text/html; charset=UTF-8");
		// 2. 클라이언트에 응답할 스트림객체 생성
		PrintWriter pw = resp.getWriter();
		pw.print("<h1>안녕</h1>");
		
		System.out.println("doPost 요청성공");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		System.out.println(id);
		System.out.println(pass);
		
		pw.print("<h1>아이디:"+id+"</h1>");
		pw.print("<h1>패스워드:"+pass+"</h1>");
	}
}

