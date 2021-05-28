package co.yedam.numgame;
/*
 * 숫자맞추기게임
 */
public class NumberGameApp {
	//컴 임의의 수 
	int com;  //컴퓨터 만든 수 (1~10) 
	int user; //사용자가 입력한 값
	
	void init() {
		//난수(1~10)
	}
	void input() {
		//scanner 를 이용해서 정수값 입력
	}
	//높다/낮다:false 정답:true
	boolean confirm() {
		//com 과 user 를 비교해서 같으면 true 리턴
		//다르면 높다/낮다 출력하고 false 리턴
	}
	void start() {
		init();
		while(true) {
			input();
			if(confirm()) {
				break;
		}
	}
}
