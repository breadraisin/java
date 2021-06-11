package co.memo.view;

import java.util.List;
import java.util.Scanner;

import co.memo.access.MemoAccess;
import co.memo.access.MemoDAO;
import co.memo.model.Memo;

public class MemoCliApp {

	MemoAccess access = null; // 데이터베이스 입출력 처리하세요.
	Scanner scanner = new Scanner(System.in);
	MemoAccess dao = new MemoDAO();

	public void start() {
		int menuNum;

		do {
			menuTitle();
			System.out.print("입력 > ");
			menuNum = scanner.nextInt();
			scanner.nextLine();
			switch (menuNum) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				findAll();
				break;
			case 5:
				findByDate();
				break;
			case 6:
				findByContent();
				break;
			}
		} while (menuNum != 0);
		System.out.println("프로그램 종료.");
	}
	
	// 메모 추가
	private void insert() {
		System.out.println("날짜입력>");
		String date = scanner.nextLine();
		System.out.println("제목입력>");
		String title = scanner.nextLine();
		System.out.println("내용입력>");
		String content = scanner.nextLine();
		
		dao.insert(date, title, content);
	}
	
	// 메모 수정
	private void update() {
		System.out.println("수정할 메모의 제목 입력>");
		String title = scanner.next();
		System.out.println("내용입력>");
		String content = scanner.next();
		dao.update(content, title);
	}
	
	// 메모 삭제
	private void delete() {
		System.out.println("삭제할 메모 제목 입력>");
		String title = scanner.next();
		dao.delete(title);
	}
	
	// 전체 조회
	private void findAll() {
		List<Memo>list = dao.FindAll();
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	// 날짜로 조회
	private void findByDate() {
		String date = scanner.next("조회할 메모의 날짜입력");
		Memo memo = dao.FindByDate(date);
		System.out.println(memo);

	}
	// 내용으로 조회
	private void findByContent() {
		String content = scanner.next("조회할 메모의 내용입력");
		Memo memo = dao.FindByContent(content);
		System.out.println(memo);
	}

	private void menuTitle() {
		System.out.println("== 메모 관리 ==");
		System.out.println("=1. 메모 추가");
		System.out.println("=2. 메모 수정");
		System.out.println("=3. 메모 삭제");
		System.out.println("=4. 전체 조회");
		System.out.println("=5. 날짜로 조회");
		System.out.println("=6. 내용으로 조회");
		System.out.println("=0. 종료");
		System.out.println("===============");

	}

}
