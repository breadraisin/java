package co.yedam.test;

/*자동차 정보
 * Car[]
 * */

//1. 클래스 선언
public class Car {
	// 필드(만들고자하는클래스의 상태값, 정보 속성)
	String company;
	String model;
	String color;
	int maxSpeed;
	int speed;

	// 생성자
	/*
	 * 1.객체 생성시에 호출되어 필드 초기화하는 특수용도의 메서드 
	 * 2.생성자 이름은 클래스명과 동일 
	 * 3.리턴 타입 없음 
	 * 값 초기화 쉽게 하려고 하나씩 하면 힘드니깐 
	 * 4.생성자 여러개 중복선언(오버로딩) 가능하지만 매겨변수의 타입과 개수는 달라야 함.
	 */
	
	Car(String company, String model, String color) {
		this(company, model, color, 0, 0);
	}

	Car() {
		this("현대", "그렌저", "블랙", 350, 0);
	}

	public Car(String model, int speed) {
		this("", model, "", 0, speed);
	}

	public Car(String company, String model, String color, int maxSpeed, int speed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		if (maxSpeed > 100) {
			this.maxSpeed = maxSpeed;
		} else {
			this.maxSpeed = 100;
		}
		if (speed > 0) {
			this.speed = speed;
		} else {
			this.speed = 50;
		}

	}

	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed
				+ ", speed=" + speed + "]";
	}

}
