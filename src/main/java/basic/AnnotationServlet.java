package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet 은 서블릿을 등록하기 위한 어노테이션
// @WebServlet 의 name 속성은 서블릿의 이름을 등록하기 위해 사용하는 속성
// 여러 속성 지정은 , 로 구분
// urlPatterns는 여러 개를 등록할 수 있으므로 배열로 관리
// annotation을 이용해서 서블릿을 등록하는 것도 web.xml에 등록하는 것과 동일하므로 서버를 restart 해야 적용됨.
// 서블릿명이 중복되면 안된다.
@WebServlet(name = "annotation_servlet", urlPatterns = {"/test/anno.do"})
public class AnnotationServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("어노테이션으로 서블릿 등록하기");
	}
}
