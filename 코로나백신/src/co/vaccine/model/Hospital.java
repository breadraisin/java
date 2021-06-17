package co.vaccine.model;

public class Hospital {
	
	int h_id;
	String h_address;
	String h_name;
	String h_phone;
	
	public Hospital() {}

	public Hospital(int h_id, String h_address, String h_name, String h_phone) {
		super();
		this.h_id = h_id;
		this.h_address = h_address;
		this.h_name = h_name;
		this.h_phone = h_phone;
	}

	public Hospital(String h_address, String h_name, String h_phone) {
		super();
		this.h_address = h_address;
		this.h_name = h_name;
		this.h_phone = h_phone;
	}

	public String getH_phone() {
		return h_phone;
	}


	public void setH_phone(String h_phone) {
		this.h_phone = h_phone;
	}


	public int getH_id() {
		return h_id;
	}
	public void setH_id(int h_id) {
		this.h_id = h_id;
	}
	public String getH_address() {
		return h_address;
	}
	public void setH_address(String h_address) {
		this.h_address = h_address;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	@Override
	public String toString() {
		return "병원 [id: " + h_id + ", 지역: " + h_address + ", 이름: " + h_name + ", 번호: " + h_phone
				+ "]";
	}
	
}
