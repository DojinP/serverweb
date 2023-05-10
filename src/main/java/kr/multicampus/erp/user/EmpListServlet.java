package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "emplist",urlPatterns = {"/emp/list.do"})
public class EmpListServlet extends HttpServlet{
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 인코딩 등 설정
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
//		boolean isDel = Boolean.parseBoolean(req.getParameter("isDel"));
//		String dId = req.getParameter("dId");
//		
//		if(isDel) {
//			out.print("<script type=")
//		}
		
		// DAO 객체 생성
		EmpDAO empDAO = new EmpDAOImpl();
		ArrayList<EmpDTO> empList = null;
		
		// 비지니스 로직 메소드 호출
		empList = empDAO.select();
		
		// 출력
		out.print("<table width=800 border=1>");
		out.print("<tr><th>부서번호</th><th>성명</th><th>사번</th><th>패스워드</th><th>주소</th><th>포인트</th><th>등급</th><th>삭제</th></tr>");
		for(int i=0; i<empList.size(); i++) {
			EmpDTO emp = empList.get(i);
			out.print("<tr>");
			out.print("<td>" + emp.getDeptno() + "</td>");
			out.print("<td>" + emp.getName() + "</td>");
			out.print("<td>" + emp.getId() + "</td>");
			out.print("<td>" + emp.getPass() + "</td>");
			out.print("<td>" + emp.getAddr() + "</td>");
			out.print("<td>" + emp.getPoint() + "</td>");
			out.print("<td>" + emp.getGrade() + "</td>");
//			out.print("<td><a href='/serverweb/emp/delete.do?test=info&id="+emp.getId()+"'>삭제</a></td>");
			out.print("<td><a href='/serverweb/emp/delete.do?id="+emp.getId()+"'>삭제</a></td>");
			out.print("</tr>");
//			out.println(empList.get(i));
		}
		out.print("</table>");
	}
	
	
}
