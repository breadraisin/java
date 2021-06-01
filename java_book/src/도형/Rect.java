package 도형;

public class Rect extends Shape implements Drawable, Movable {
	
	int h;
	
	public Rect(int h, int w) {
		super(w);//this.w=w;
		this.h=h;
	}
	@Override
	public void area() {
		System.out.println("rect");
	}
	@Override
	public void draw() {
		System.out.println("rect draw");				
	}
	@Override
	public void move() {
		System.out.println("rect move");				
		
	}

}
