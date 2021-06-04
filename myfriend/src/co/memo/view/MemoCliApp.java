package co.memo.view;

import java.util.List;

import co.friend.util.ScannerUtil;
import co.memo.access.MemoList;
import co.memo.model.Memo;
import co.memo.util.ScannerUtil2;

public class MemoCliApp {

	MemoList memoList = new MemoList();

	// 프로그램 시작
	public void start() {
		int menunum;
		do {
			menuTitle(); // 메뉴출력
			menunum = ScannerUtil.readInt("입력"); // 메뉴 선택
			switch (menunum) { // 실행
			case 1:insert();	break;
			case 2:update();	break;
			case 3:delete();	break;
			case 4:selectAll(); break;
			case 5:findDate(); 	break;
			case 6: findContent(); break;
			}
		} while (menunum != 0);
	}

	// 메뉴출력
	public void menuTitle() {
		System.out.println("==메모  관리==");
		System.out.println("==1.메모등록==");
		System.out.println("==2.메모수정==");
		System.out.println("==3.메모삭제==");
		System.out.println("==4.메모전체조회==");
		System.out.println("==5.날짜검색==");
		System.out.println("==6.내용검색==");
		System.out.println("==0.종료==");

	}

	// 메모등록
	public void insert() {
			Memo memo = ScannerUtil2.readMemo();
			memoList.insert(memo);
		}

	// 메모수정
	public void update() {
		Memo memo = new Memo();
		memo.setDate(ScannerUtil2.readStr("날짜입력"));
		memo.setContent(ScannerUtil2.readStr("내용입력"));
		memoList.update(memo);
	}

	// 메모삭제
	public void delete() {
		String content = ScannerUtil2.readStr();
		memoList.delete(content);
	}

	// 메모전체조회
	public void selectAll() {
		List<Memo> list = memoList.selectAll();
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

	// 날짜검색
	public void findDate() {
		String date = ScannerUtil2.readStr();
		Memo memo = memoList.findDate(date);
		System.out.println(memo);
	}

	// 내용검색
	public void findContent() {
		String content = ScannerUtil2.readStr();
		Memo memo = memoList.findContent(content);
		System.out.println(memo);
	}
}
