package co.yedam.app;

import java.util.Scanner;

public class Memberinfo {
	
	String name; //중괄호는 변수 사용 범위
	String id;
	String tel;
	// 키, 몸무게
	double height;
	double weight; 
	
	double result = 0;
	String s = "";

	
	Scanner scanner = new Scanner(System.in);
		void heightWeightInput() {
			
			System.out.print("몸무게:");
			weight = scanner.nextDouble();
			System.out.print("키:");
			height = scanner.nextDouble();

		}
		
		String bmi() {
			result = (weight/((height/100)*(height/100)));
			if (result<=18.5) {
				System.out.println("저체중");
			} else if(result<=23) {
				System.out.println("정상");
			} else if(result<=25) {
				System.out.println("과체중");
			} else if(result<=30) {
				System.out.println("비만");
			} else {
				System.out.println("고도비만");
			}
			
		return s;
		
		}
		
		
	void input() {
		//코드 작성
		System.out.print("1.이름:");
		name = scanner.next();
		System.out.print("2.주민번호:");
		id = scanner.next();
		System.out.print("3.전화번호:");
		tel = scanner.next();
		//return 생략
	}
	
	void print() {
		System.out.println("[입력한 내용]");
		System.out.println(name);
		System.out.println(id);
		System.out.println(tel);
		
		
	}
}
