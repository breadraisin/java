package 클래스;

public class CalcStatic {
	//final : (상수)변경불가
	//static : 모든 객체가 공유하는 필드
	final static double PI = 3.14;
	
	public static int add(int n1, int n2) {
		return n1 + n2;
	}
	
	
	
	
	@Override
	public String toString() {
		return "CalcStatic [pi=" + PI + "]";
	}
	
	
	
}
