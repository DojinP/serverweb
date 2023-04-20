package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class SecondServlet extends HttpServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int dan = 7;
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i));
		}
	}

}
