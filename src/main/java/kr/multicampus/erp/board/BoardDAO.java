package kr.multicampus.erp.board;

import java.util.ArrayList;

public interface BoardDAO {
	// 게시글 등록을 위한 메소드
	public int insert(BoardDTO user);
	// 게시글 전체목록을 조회하는 메소드
	public ArrayList<BoardDTO> select();
	// 사원 삭제를 위한 메소드
	//public int delete(String id);
	// 게시글을 조회하는 메소드
	public BoardDTO read(int boardNo); 
}
