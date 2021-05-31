package co.yedam.exam;

public class ExamScore {
	
	String examNum;
	int kor;
	int his;
	int eng;
	int avg;
	
	ExamScore(String examNum, int kor, int his, int eng){
		this.examNum = examNum;
		this.kor = kor;
		this.his = his;
		this.eng = eng;
		this.avg = (kor+his+eng)/3;
	}
	
	boolean isPass(){
		if(avg>=60 && kor>=40 && eng>=40 && his>=40) {
			return true;
		} else {
			return false; 
		}
	}
	
	
}
