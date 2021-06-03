package 클래스;

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

	@Override
	public boolean equals(Object obj) {
		//Member m1 = ((Member)obj);
		//Member m2 = ((Member)obj);
		//return m1.id ==this.id && m2.id == this.id && m1.name ==this.name && m2.name == this.name;
		
		Member s = (Member)obj;
		return this.id.equals(s.id) && this.name.equals(s.name);
		}	
	
	
}

