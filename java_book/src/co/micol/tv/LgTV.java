package co.micol.tv;

public class LgTV implements RemoteControl{
	public LgTV() {
		System.out.println("LgTV 객체생성");
	}

	@Override
	public void powerOn() {
		System.out.println("엘지 TV--전원 on");
		
	}

	@Override
	public void powerOff() {
		System.out.println("엘지 TV--전원 off");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("엘지 TV--볼륨 up");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("엘지 TV--볼륨 down");
		
	}

}
