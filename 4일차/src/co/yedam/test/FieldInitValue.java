package co.yedam.test;

import java.util.Arrays;

//기본 데이터형 8타입은 기본값은 0으로 초기화 
//참조변수(String,[])의 초기값은 null
public class FieldInitValue {
	@Override
	public String toString() {
		return "FieldInitValue [b=" + b + ", s=" + s + ", i=" + i + ", l=" + l + ", f=" + f + ", d=" + d + ", bool="
				+ bool + ", c=" + c + ", str=" + str + ", arr=" + Arrays.toString(arr) + "]";
	}
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	boolean bool;
	char c;
	
	String str; 
	int [] arr;
	
	//생성자
	FieldInitValue(int j, double k){
		i = j;
		d = k;
	}
	
}
