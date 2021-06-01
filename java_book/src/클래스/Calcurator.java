package 클래스;

public class Calcurator {
	//싱글톤
	
	private static Calcurator instance = new Calcurator();
	public static Calcurator getInstance() {
		return instance;
	}
	
	private Calcurator() {}
	public int add(int a, int b) {
		return a+b;
	}
}
