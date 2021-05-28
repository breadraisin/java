package co.yedam.score;

public class AppMain {

	public static void main(String[] args) {
		ScoreArrApp score = new ScoreArrApp();
		score.printH();
		System.out.printf("총점=%04d\n",score.total());
		System.out.printf("평점=%-6.2f", score.avg());
	}

}
