package 도형;

public class Circle extends Shape implements Drawable ,Movable {

	public Circle (int w) {
		super(w);//this.w = w; 부모의 인수w 호출
	}

	@Override
	public void area() { //추상이라 구현해야됨
		result = w*w*3.14;
		System.out.println("circle");
		
	}

	@Override
	public void draw() {
		System.out.println("circle draw");
		
	}

	@Override
	public void move() {
		System.out.println("circle move");				
		
	}
	
}
