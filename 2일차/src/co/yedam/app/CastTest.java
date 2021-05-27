//package co.yedam.app;
//
////import java.util.Scanner;
//
///*
// * ����ȯ : ĳ��Ʈ������ (Ÿ��)
// * ������ byte < short < int < long
// * �Ǽ��� 			   float < double
// * 
// * ��Ʈ�� -----> byte		Byte.parseByte(����)
// * 				short		Short.parseShort(����)
// * 				int			Integer.parseInt(����)
// * 				long		Long.parseLong(����)
// * 				float		Float.parseFloat(����) 
// * 				double
// * 				char
// * 				boolean
// * 
// * <----- 
// * Byte.valueOf(����)
// */
//public class CastTest {
//
//	public static void main(String[] args) {
//		// �ڵ�����ȯ
//		int a = 10;
//		long b = a;
//		
//		//��������ȯ
//		a = (int)b;
//		
//		//char(����) -> int(�ڵ�)
//		char c = 'Z';
//		System.out.println((int)c);
//		int d = 97;
//		System.out.println((char)d);
//		
//		//�Ǽ�(double) -> ����(int)
////		double e = 10.5;
////		int f = (long)e;
////		System.out.println(f);
//		
//		//5 + 10.5 // 5�� ��Ʈ 10.5�� ���� ������ Ŀ�� 5 ����� �ڵ�
//		
//		
//		//���� ������ �ڵ����� �� ��ȯ
////		double g = 5 + 10.5;
////		String h = "hi" + 5; // ū ������ �ڵ����� �� ��ȯ
////		System.out.println(h);		
//		
//		// 
//		System.out.println(5/2);		// �������� ����ϸ� �������� 
//		System.out.println(5/(double)2);		// 5�� ��Ʈ 2�� ���� 5�� ū ���� �������� �ٲ�
//		// �ڹٴ� ���� �ɷ� �ٲٰ� ���.. , �������� �������� ���� 
//		
//		double i = 5/(double)2; 
//		System.out.println(i); //
//		
//		double g = 5 + 10.5;
//		String h = "hi" + 5; 
//		System.out.println(h);
//		System.out.println("hi" + 5 + 10);
//		System.out.println(5 + 10 + "hi");
//		
//		//��Ʈ�� -> int
//		String s1 = "123";
//		int j = Integer.parseInt(s1);
//		
//		//int -> ��Ʈ��
//		String s2 = String.valueOf(123);
//		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("�Է�:");
//		String greet = scanner.next();
//		System.out.println(greet);
//	}
//
//}
