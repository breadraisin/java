package co.yedam.test;

public class CarExample {

	public static void main(String[] args) {
		//2.객체 생성(인스턴스)
		Car myCar = new Car();
		myCar.company="삼성자동차";
		myCar.maxSpeed=400;
		myCar.color="레드";
		System.out.println("제작회사"+myCar.company);
		System.out.println("속도"+myCar.speed);
		 
		 //생성자
		 Car youCar = new Car("벤츠","SM6","블루");
		 System.out.println(youCar);//투스트링생략 알아서 호출가능
			
		 Car minicar = new Car("코나",40);
		 System.out.println(minicar);
	}

}
