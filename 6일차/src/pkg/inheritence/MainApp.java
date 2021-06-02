package pkg.inheritence;

public class MainApp {

	public static void main(String[] args) {
		A a = new D();				//자동형변환
		//int temp = ((D)a).sd;		//강제형변환
		
		//A o = new A();
		//((D)o).sd = 10; //실행오류, 런타임시 오류발생
		
		System.out.println(a instanceof A);
		System.out.println(a instanceof B);
		System.out.println(a instanceof D);
		System.out.println(a instanceof X);


		B b = new B();
		b = new D();
		
	}

}
