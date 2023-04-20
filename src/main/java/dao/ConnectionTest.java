//** jdbc 메모 참고 **
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		// 127.0.0.1 : localhost
		// PC IP : 172.30.1.50
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC";
		// Error 나는 경우 jre 11 version 으로 설정하여 실행
		// 여전히 에러가 난다면 드라이버에서 ServerTimezone을 인식 못하는 경우, 아래와 같이 실행
		// String url = "jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC"; 
		//String url2 = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "exam";
		String pw = "exam";
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading 성공.");
			
			// 2. DB서버 접속
			Connection conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB Connection 성공 : " + conn );
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading 실패.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB Connection 실패.");
			e.printStackTrace();
		}
	}

}
