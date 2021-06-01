package 배열;

public class Score {
	
	String name;
	int kor;
	int eng;
	int mat;
	int total;
	double avg;
	
	public Score(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	
		this.total = kor+mat+eng;
		this.avg = (double)this.total /3;
	}
	


	
}
