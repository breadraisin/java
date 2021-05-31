package co.yedam.member;

import java.util.Scanner;

public class MemberSerivceExample {

//	public static void main(String[] args) {
//		MemberService memberService = new MemberService();
//		memberService.insert("hong", "12345", "홍길동", 0);
//		memberService.insert("kim", "33333", "김유신", 0);
//		memberService.insert("park", "66", "최기자", 0);
//
//		memberService.printList();
//		memberService.printMember(1);
//
//		
//		memberService.login("kim", "33333");
//		memberService.login("kim", "1234");
//
//		
////		boolean result = memberService.login("hong", "12345");
////		if (result) {
////			System.out.println("로그인 되었습니다.");
////			memberService.logout("hong");
////		} else {
////			System.out.println("id, password 올바르지 않음");
////		}
//
//	}
	public static void main(String[] args) {

		MemberService m = new MemberService();
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		int selctNo = 0;
		while (run) {
			System.out.println("1.등록 2.전체조회 3.번호로 조회 4.로그인 5.id로 조회 6.종료");
			System.out.println("선택>");
			selctNo = scanner.nextInt();
			if (selctNo == 1) {
				m.insert();
			} else if (selctNo == 2) {
				m.printList();
			} else if (selctNo == 3) {
				int a = scanner.nextInt();
				m.printMember(a);
			} else if (selctNo == 4) {
				m.login();	
			}else if (selctNo == 5) {
				m.logout("kim");
			} 
			else if (selctNo == 6) {
				run = false;
				System.out.println("종료");
			
		}

	}
}

}
