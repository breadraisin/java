package Sukze;

import java.util.Scanner;

public class Num {

	// 컴 임의의 수
	int com; // 컴퓨터 만든 수 (1~10)
	int user; // 사용자가 입력한 값

	void init() {
		com = (int) (Math.random() * 10) + 1;
		// 난수(1~10)
	}

	void input() {
		// scanner 를 이용해서 정수값 입력
		Scanner s = new Scanner(System.in);
		user = s.nextInt();

	}

	boolean confirm() {
		// 스캐너 정수 입력
		Scanner s = new Scanner(System.in);
		System.out.println("게임을 시작할까요(y/n)");
		char re = s.next().charAt(0);
		if (re == 'Y' || re == 'y') {
			return true;
		} else {
			System.out.println("종료");
			return false;
		}
		
		// com 과 user 를 비교해서 같으면 true 리턴
		// 다르면 높다/낮다 출력하고 false 리턴
	}

	void start() {
		init();
		while (true) {
			System.out.println("숫자를 입력하세요");
			input();
			
			if (com > user) {
				System.out.println("크다");
			} else if (user > com){
				System.out.println("작다");
			} else if (user ==com) {
				System.out.println("정답");
				break;
				
			}
		}
	}
}
