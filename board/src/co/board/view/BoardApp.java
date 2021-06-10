package co.board.view;

import java.util.List;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.model.Board;
import co.board.util.ScannerUtil;


public class BoardApp {
	
	BoardAccess boardList = new BoardDAO();
	
	//프로그램 시작
		public void start() {
		int menunum;
		do {
			menuTitle(); //메뉴출력
			menunum = ScannerUtil.readInt("입력"); //메뉴 선택
			switch(menunum) { //실행
			case 1:	selectAll();		break;
			case 2:	insert();			break;
			case 3:	update();			break;
			case 4:	delete();			break;
			case 5:	selectOne();		break;
			}
		} while(menunum != 0);
	}
	
	//메뉴출력
	public void menuTitle() {
		System.out.println("===게시판  관리===");
		System.out.println("===1.전체리스트===");
		System.out.println("===2.글 등록===");
		System.out.println("===3.글 수정===");
		System.out.println("===4.글 삭제===");
		System.out.println("===5.한건 조회===");
	
			
		}
	
	//전체리스트
	public void selectAll() {
		List<Board> list = boardList.selectAll();
		for(Board board : list ) {
			System.out.println(board);
		}
	}
	
	//글 등록
	public void insert() {
		System.out.println("제목입력");
		String title = ScannerUtil.readStr();
		System.out.println("내용입력");
		String content = ScannerUtil.readStr();
		System.out.println("작성자입력");
		String writer = ScannerUtil.readStr();
		
		Board board = new Board(title,content,writer);
		boardList.insert(board);
		
		}
	
	//글 수정
	public void update() {
		Board board = new Board();
		board.setB_id(ScannerUtil.readStr("글 번호 입력"));
		board.setB_content(ScannerUtil.readStr("글 내용 수정"));
		boardList.update(board);
	}
	
	//글 삭제
	public void delete() {
		String b_id = ScannerUtil.readStr();
		boardList.delete(b_id);
	}
	
	//한건 조회
	public void selectOne() {
		String b_id = ScannerUtil.readStr();
		Board board = boardList.selectOne(b_id);
		System.out.println(board);
		}
		
	
	
	
	
}
