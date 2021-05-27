package co.yedam.gugudan;

public class GugudanApp {

	//입력받은 단만 출력
	void printDan(int dan) {
		//2*1=2 2*9=18
		for(int i=1;i<10;i++){
			System.out.println(dan*i);
		}
	}
	void printRange(int s, int e) {
		//s단부터 e단까지 출력
		for (int i=s;i<e;i++){
			for(int j=1;j<10;j++) {
				System.out.println(s*j);
			}
		}
	}
	
	void printAll() {
		//9단까지 모두 출력
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.println(i*j);
			}
		}
	}
}
//	void printAllReverse() {
//		//9단까지 거꾸로 출력
//		for(int i=1;i<10;i++) {
//			for(int j=1;j<10;j++) {
//				System.out.println(i*j);
//	}
//}
//}