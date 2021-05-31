package co.yedam.exam;

public class ExamScoreExample {

	public static void main(String[] args) {
		ExamScore examScore = new ExamScore("1",70,70,70);
		System.out.println(examScore.isPass());
	}

}
