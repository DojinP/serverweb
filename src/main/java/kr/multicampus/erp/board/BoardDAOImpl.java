package kr.multicampus.erp.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import fw.DBUtil;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public int insert(BoardDTO user) {
		String sql = "insert into board values(null,?,?,?,sysdate())";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, user.getTitle());
			ptmt.setString(2, user.getWriter());
			ptmt.setString(3, user.getContent());
			
			result = ptmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		
		return result;
	}

	@Override
	public ArrayList<BoardDTO> select() {
		String sql = "select * from board";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> result = new ArrayList<>();
		
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				result.add(new BoardDTO(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		
		return result;
	}

	@Override
	public BoardDTO read(int boardNo) {
		String sql = "select * from board where boardNo = ?";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		BoardDTO result = null;
		
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, boardNo);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				result = new BoardDTO(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		
		return result;
	}

}