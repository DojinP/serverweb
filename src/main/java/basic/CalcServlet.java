package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		// 1. 클라이언트의 요청정보 추출
		int num1 = Integer.parseInt(req.getParameter("num1"));
		String method = req.getParameter("method");
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		// 2. 비지니스 로직을 구현 - - - - - X
		// 2. 비지니스 메소드 호출
		Calc calcObj = new Calc();
		int result = calcObj.calc(num1, method, num2);
		
		// 3. 클라이언트에 응답할 메시지를 생성
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>계산결과</h1><hr/>");
		pw.write("<h3>num1의 "+num1+"과 num2의 "+num2+"를 '"+method+"' 연산한 결과는 "+result+"입니다.</h3>");
		
	}
}
