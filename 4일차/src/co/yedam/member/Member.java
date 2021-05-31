package co.yedam.member;

public class Member {
	
	String name;
	String id;
	String password;
	int age;
	
	//기본 생성자
	Member(){};
	
	//모든 필드를 초기화하는 생성자
	Member(String name, String id, String password, int age){
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
		}

	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", password=" + password + ", age=" + age + "]";
	}	
}

