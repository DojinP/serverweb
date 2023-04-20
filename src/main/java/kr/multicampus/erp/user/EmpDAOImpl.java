package kr.multicampus.erp.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fw.DBUtil;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public int insert(EmpDTO user) {
		String sql = "insert into myemp values(?, ?, ?, ?, ?, 1000, ?)";
		Connection conn = null;
		PreparedStatement ptmt = null;
		int result = 0;
		
		try {
			conn = DBUtil.getConnect();
			ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, user.getDeptno());
			ptmt.setString(2, user.getName());
			ptmt.setString(3, user.getId());
			ptmt.setString(4, user.getPass());
			ptmt.setString(5, user.getAddr());
			ptmt.setString(6, user.getGrade());
			
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, conn);
		}
		
		return result;
	}

}
