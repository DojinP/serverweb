package basic;

import java.io.IOException;
import java.io.PrintWriter;
// 패키지가 톰캣 10버전부터 jakarta.servlet.ServletException
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>customer</h1><hr/>");
		
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String passwd = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String job = req.getParameter("job");
		String[] item = req.getParameterValues("item");
		
		pw.write("<h1>아이디:"+userId+"</h1>");
		pw.write("<h1>성명:"+userName+"</h1>");
		pw.write("<h1>패스워드:"+passwd+"</h1>");
		pw.write("<h1>성별:"+gender+"</h1>");
		pw.write("<h1>직업:"+job+"</h1>");
		pw.write("<h1>좋아하는 항목:");
		for (int i = 0; i < item.length; i++) {
			pw.write(item[i]+" ");
		}
		pw.write("</h1>");
		
	}
}
