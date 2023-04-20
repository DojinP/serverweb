package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTestServlet extends HttpServlet{
	public LifeCycleTestServlet() {
		System.out.println("LifeCycleTestServlet 객체생성...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("inin() 호출...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() 호출...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() 호출...");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출... : " + req.getMethod());
		if(req.getMethod().equals("GET")) {
			doGet(req, resp);
		}else {
			doPost(req, resp);
		}
	}

	// Servlet 객체가 소멸될 때 호출
	// Servlet 객체의 소멸
	//  - 서블릿 객체가 컴파일 될 때
	//  - WAS가 reload 될 때
	//  - context가 reload 될 때
	@Override
	public void destroy() {
		System.out.println("destroy() 호출...");
	}
	
}
