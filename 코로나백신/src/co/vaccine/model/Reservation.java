package co.vaccine.model;

public class Reservation {
	
	String h_name;
	String u_name;
	String day;
	
	public Reservation() {}

	
	public Reservation(String h_name, String u_name, String day) {
		super();
		this.h_name = h_name;
		this.u_name = u_name;
		this.day = day;
	}

	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "예약정보 [병원: " + h_name + ", 이름: " + u_name + ", 예약날짜: " + day + "]";
	}
	
	
}
