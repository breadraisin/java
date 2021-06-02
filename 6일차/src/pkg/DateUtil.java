package pkg;
/*
 * 정적메서드 안에서는 정적필드만 접근 가능
 * 접근제어자 : private > default > protected			 > public
 * 			 클래스내부   같은패키지   다른패키지-상속         모두 허용
 * 
 */
public class DateUtil {

	public static String curDate(){
		return "2021";
	}
}



//String date = "20210610";
//
//
//
//static String curDate(){
//	DateUtil dateUtil = new DateUtil();
//	return dateUtil.date;

//public class DateUtil {
//
//	static String date = "20210610";
//	static String curDate(){
//		return date;
//	}
