package 도형;

public class Tri extends Shape implements Drawable, Movable{
	
	int h;
	
	public Tri(int h, int w) {
		super(w);//this.w=w;
		this.h=h;
	}

	@Override //추상이니깐 해야됨
	public void area() {
		System.out.println("tri");
		
	}

	@Override
	public void draw() {
		System.out.println("tri draw");		
	}

	@Override
	public void move() {
		System.out.println("tri move");				
		
	}
}
