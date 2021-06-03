package abc;

import java.util.Scanner;

public class RentService extends Rent implements Service{
	
	Rent[] rents;
	int cnt;			//입력건수
	int maxCnt = 10;	//최대건수
	
	Scanner scanner = new Scanner(System.in);
	
	public RentService() {
		rents = new Rent[maxCnt];
	}
	
	//등록
	public void input() {
		if(cnt > maxCnt) {
			System.out.println("더 이상 추가할 수 없습니다.");
			return;
		}
		System.out.printf("제목>");
		String title = scanner.next();
		System.out.print("저자>");
		String name = scanner.next();
		String date = "02.06.2021";

		rents[cnt++] = new Rent(title, name, date); 
		System.out.println("등록된 건수:" + cnt);
	}
	
	//수정
	public void update() {
		System.out.printf("수정할 번호>");
		int idx = scanner.nextInt();
		if(idx >= cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.print("저자>");
		String title = scanner.next();
		String name = scanner.next();

		rents[idx].setTitle(title); 
		rents[idx].setTitle(name); 

		System.out.println("수정되었습니다.");
	}
	
	//삭제
	public void delete() {
		System.out.printf("삭제할 번호>");
		int idx = scanner.nextInt();
		if(idx > cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		for(int i=idx; i<cnt-1; i++) {
			rents[i] = rents[i+1];
		}
		cnt--;
		System.out.println("삭제되었습니다.");
	}
	
	//전체조회
	public void selectAll() {
		System.out.println(String.format("%-20s %-20s", "도서명", "저자"));
		System.out.println("================================================================");
		for(int i=0; i<cnt; i++) {
			System.out.println(String.format("%-20s %-20s", rents[i].getTitle(), rents[i].getName()));
		}
		System.out.println("================================================================");
	}
	
	//단건조회(타이틀)
	public void selectOne() {
		System.out.printf("조회할 번호>");
		int idx = scanner.nextInt();
		if(idx > cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.println(String.format("도서명:%s   저자:%s", rents[idx].getTitle(), rents[idx].getName()));
	}
	
}
