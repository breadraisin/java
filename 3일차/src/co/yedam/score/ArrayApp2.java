package co.yedam.score;

import java.util.Scanner;

public class ArrayApp2 {
	int[] scores; // 성적
	int studentNum; // 학생수

	Scanner scanner = new Scanner(System.in);

	void init() {
		System.out.println("인원수>");
		studentNum = scanner.nextInt();
		scores = new int[studentNum];
	}

	void input() { // 배열에 초기값 지정
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("scores[%d]>", i);
			scores[i] = scanner.nextInt();
		}
	}

	void print() {
		// 배열 출력
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("score[%d] %d\n",i, scores[i]);
		}
		System.out.println();
	}

	void total() {
		// 합계
		int result = 0;
		for (int i = 0; i < scores.length; i++) {
			result += scores[i];
		}
		System.out.println("평균=" + result/scores.length);
	}
	
	

	void max() {
		int max = scores[0];
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
		}System.out.println("최대값="+max);

	}

	public static void main(String[] args) {

		ArrayApp2 app = new ArrayApp2();
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		int selctNo = 0;
		while (run) {
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료");
			System.out.println("선택>");
			selctNo = scanner.nextInt();
			if (selctNo == 1) {
				app.init();
			} else if (selctNo == 2) {
				app.input();
			} else if (selctNo == 3) {
				app.print();
			} else if (selctNo == 4) {
				app.max();
				app.total();
			} else if (selctNo == 5) {
				run = false;
				System.out.println("종료");
			
		}

	}
}
}