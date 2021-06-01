package co.sikmul.fly;

public class Human extends Animal {
	
	public void think() {
		System.out.println("think");
	}

	@Override
	public void eat() {
		System.out.println("고기");
	}
	
}
