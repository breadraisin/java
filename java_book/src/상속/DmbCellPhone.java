package 상속;

public class DmbCellPhone extends CellPhone {
	
	int channel;
	public DmbCellPhone() {
		System.out.println("DmbCellPhone 기본생성자");
		}
	
	public DmbCellPhone(String model, String color, int channel) {
		super(model,color);
		//this.model = model;
		//this.color = color;
		this.channel = channel;
		System.out.println("DmbCellPhone 생성자");

	}
	void turnOnDmb() {
		System.out.println("채널" + channel + "번 방송수신 시작");
	}
	void turnOffDmb() {
		System.out.println("DMB 방송수신을 멈춥니다.");
	}
	void changeChnnel(int channel) {
		this.channel = channel;
		System.out.println("채널 변경");
	}

	@Override //재정의	//오버로딩(중복정의)
	//상속 받은 메서드를 수정
	void powerOn() {
		super.powerOn();
		System.out.println("Dmb 전원 on");
	}
	
}
