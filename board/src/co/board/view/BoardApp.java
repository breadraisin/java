package co.board.view;

import java.util.List;
import java.util.Scanner;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.model.Board;
import co.board.util.ScannerUtil;

public class BoardApp {

	BoardAccess boardList = new BoardDAO();
	Scanner scanner = new Scanner(System.in);

	// 프로그램 시작
	public void start() {
		
		System.out.println("아이디 입력");
		String id = ScannerUtil.readStr();
		System.out.println("비밀번호 입력");
		String pass = ScannerUtil.readStr();
		
		
		
		int menunum;
		do {
			menuTitle(); // 메뉴출력
			menunum = ScannerUtil.readInt("입력"); // 메뉴 선택
			switch (menunum) { // 실행
			case 1:
				selectAll();
				break;
			case 2:
				insert();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				selectOne();
				break;
			case 6:
				insertD();
				break;
			}
		} while (menunum != 0);
	}

	// 메뉴출력
	public void menuTitle() {
		System.out.println("===게시판  관리===");
		System.out.println("===1.전체리스트===");
		System.out.println("===2.글 등록===");
		System.out.println("===3.글 수정===");
		System.out.println("===4.글 삭제===");
		System.out.println("===5.한건 조회===");
		System.out.println("===6.댓글===");
		System.out.println("===7.로그인===");

	}

	// 전체리스트
	public void selectAll() {
		List<Board> list = boardList.selectAll();
		for (Board board : list) {
			System.out.println(
					"글 번호 : " + board.getB_id() + ", 제목 : " + board.getB_title() + ", 작성자 : " + board.getB_writer());
		}
	}

	// 글 등록
	public void insert() {
		System.out.println("제목입력");
		String title = ScannerUtil.readStr();
		System.out.println("내용입력");
		String content = ScannerUtil.readStr();
		System.out.println("작성자입력");
		String writer = ScannerUtil.readStr();

		Board board = new Board(title, content, writer);
		boardList.insert(board);

	}

	// 글 수정
	public void update() {
		Board board = new Board();
		board.setB_id(ScannerUtil.readInt("글 번호 입력"));
		board.setB_content(ScannerUtil.readStr("글 내용 수정"));
		boardList.update(board);
	}

	// 글 삭제
	public void delete() {
		int b_id = ScannerUtil.readInt();
		boardList.delete(b_id);
	}

	// 한건 조회
	public void selectOne() {
		int b_id = ScannerUtil.readInt();
		Board board = boardList.selectOne(b_id);
		System.out.println(board);
	}

	// 댓글
	public void insertD() {
		int menunum;
		int a;
		BoardDAO dao = new BoardDAO();
		
		do {
			menunum = ScannerUtil.readInt("1.댓글조회 2.댓글등록");
		switch(menunum) {
		case 1:
			System.out.println("조회할 글 번호");
			a =  ScannerUtil.readInt("입력");
			Board board = dao.selectOneD();	
			System.out.println("글번호: "+ board.getB_id() + "댓글: " + board.getB_content());
			break;
			
		case 2 : 
			System.out.println("글 번호 >");
			a =  ScannerUtil.readInt("입력");
			System.out.println("댓글 내용 >");
			String content = scanner.next();
			
			board = new Board(a, content);
			dao.insertD(board);	
		
		}	
		}while (menunum != 0);
	}
	
}

