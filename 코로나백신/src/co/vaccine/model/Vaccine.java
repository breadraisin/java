package co.vaccine.model;

public class Vaccine {
	
	protected String id;
	protected String pass;
	
	protected String name;
	protected String age;
	protected String address;
	protected String phone;
	
	public Vaccine() {}
	
	public Vaccine(String id, String pass, String name, String age, String address, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}


	public Vaccine(String id, String pass, String name, String age, String address, String phone, String type) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;	}

	public Vaccine(String age) {
		super();
		this.age = age;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Vaccine [ 이름: " + name + ", 주민번호 앞자리: " + age
				+ ", 지역: " + address + ", 폰번호: " + phone +  "]";
	}
	
	
	
}
