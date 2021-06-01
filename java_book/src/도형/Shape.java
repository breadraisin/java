package 도형;

public abstract class Shape { //클래스도 추상으로 선언
	int w;
	double result;
	
	public Shape() {}
	
	public Shape(int w) {
		this.w = w;
	}
	
	public void print() {
		System.out.println("shape");
	}
	
	public abstract void area(); // 어떻게 동작하는 지 정의 안함

	
}
