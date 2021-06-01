package co.sikmul.fly;

public class AppMain {

	public static void main(String[] args) {
		Human human = new Human();
		human.sleep();
		human.think();
		
		Bird bird = new Bird();
		bird.layEggs();
		bird.eat();
		
		Superman superman = new Superman();
		superman.fly();
	}

}
