package 클래스;

public class StringEqual {

	public static void main(String[] args) {
		String s1 = "hello";	//상수
		String s2 = "hello";
		
		String s3 = new String("hello"); //힙
 		String s4 = new String("hello");
		
		System.out.println(s1 ==s2);
		System.out.println(s3 ==s4);
		System.out.println(s1 ==s3);
		
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s4));
		
		StringBuffer sb = new StringBuffer("hello world");
		sb.insert(5,"!!!");
		System.out.println(sb.toString());
		sb.replace(0, 5, "hi");
		System.out.println(sb.toString());
		//추가삭제할일있을때 
		
	}

}
