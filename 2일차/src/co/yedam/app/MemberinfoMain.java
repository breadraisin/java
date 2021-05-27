package co.yedam.app;

public class MemberinfoMain {
	
	public static void main(String[] args) {
		Memberinfo member = new Memberinfo();
		member.input();
		member.print();
		
		member.heightWeightInput();
		member.bmi();
		System.out.println(member.result + ":" + member.s);
		
	}

}
