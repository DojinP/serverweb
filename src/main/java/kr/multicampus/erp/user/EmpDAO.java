package kr.multicampus.erp.user;

import java.util.ArrayList;

public interface EmpDAO {
	// 사원 등록을 위한 메소드
	public int insert(EmpDTO user);
	// 전체 사원 목록을 조회하는 메소드
	public ArrayList<EmpDTO> select();
	// 사원 삭제를 위한 메소드
	public int delete(String id);
	// 사원 정보를 조회하는 메소드
	public EmpDTO read(String id);
	// 로그인 메소드
	public EmpDTO login(String id, String pass); 
}
