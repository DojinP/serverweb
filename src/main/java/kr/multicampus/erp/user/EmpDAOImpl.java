package kr.multicampus.erp.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	@Override
	public ArrayList<EmpDTO> select() {
		
//		System.out.println("select() 실행");
		
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from myemp";
		ArrayList<EmpDTO> ret = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnect();
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				ret.add(new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
			}
//			System.out.println("record count : " + ret.size());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, conn);
		}
		
		return ret;
	}

	@Override
	public int delete(String id) {
		String sql = "delete from myemp where id = ?";
		Connection conn = null;
		PreparedStatement ptmt = null;
		int result = 0;
		
		try {
			conn = DBUtil.getConnect();
			ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, id);
			
			result = ptmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, conn);
		}
		
		return result;
	}
	
	@Override
	public EmpDTO read(String id) {
		String sql = "select * from myemp where id = ?";
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		EmpDTO result = null;
		
		try {
			conn = DBUtil.getConnect();
			ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, id);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				result = new EmpDTO(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, conn);
		}
		
		return result;
	}

	@Override
	public EmpDTO login(String id, String pass) {
//		System.out.println("====================로그인 진입=====================");
		String sql = "select * from myemp where id = ? and pass = ?";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		EmpDTO emp = null;
		
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			
			System.out.println(ptmt.toString());
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpDTO(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7));
			}
			
//			System.out.println(emp.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		
		return emp;
	}
	
}

