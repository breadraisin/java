package co.sikmul.fly;

//다중상속 안됨
public class Superman extends Human implements Flyer {
	
	@Override
	public void takeOff() {
		System.out.println("takeOff2");
	}
	@Override
	public void fly() {
		System.out.println("fly2");
	}
	@Override
	public void land() {
		System.out.println("land2");
	}
}
