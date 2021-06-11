package co.board.access;

import java.util.ArrayList;

import co.board.model.Board;

public interface BoardAccess {

	//1.전체리스트
	public ArrayList<Board> selectAll();
	
	//2.글 등록
	public void insert(Board board);
	
	//3.글 수정
	public void update(Board board);
	
	//4.글 삭제
	public void delete(int b_id);
	
	//5.한건 조회
	public Board selectOne(int b_id);
	
	//6.댓글
	public void insertD(Board board);
	public Board selectOneD();
	
	//7.로그인
	public boolean login(String u_id, String u_pass);


	
	
}
