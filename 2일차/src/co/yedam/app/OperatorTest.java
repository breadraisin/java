package co.yedam.app;
/*
 * 연산자 테스트
 * 논리 : and(&&) or (||)
 * a++ ===> a= a+1
 * ++a
 * 조건 ? t : f ==> if 조건:
 * 					  ...
 * 			       else:
 * 					  ...
 */
public class OperatorTest {

	public static void main(String[] args) {
		//증감연산자
		int x = 1;
		int y = 1;
		int result1 = x++ + 10;
		System.out.println(x +" " + result1);
		System.out.println(String.format("x=%d 결과=%d",x,result1));
		
		//a++ + b 덧셈하기 전 a 증가
		//++a + b 덧셈한 후 a 증가
		// ++a + b++ 덧셈하기 전 a 증가 덧셈한 후 b 증가
		
		//논리연산
		System.out.println(x>0 && y>0);
		System.out.println(x==0 && y==0);
		System.out.println(! (x==0 && y==0)); 
		System.out.println(! (x==0) || ! (y==0)); 
		
		x=3;
		//삼항연산
		System.out.println(x>=0 && y>=0 ? "둘다 양수" : "아님");
		System.out.println(x%2==0 ? "짝수" : "홀수");

	}	


}



