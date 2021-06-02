package pkg;
/*
 * 
 */
public class MemberInfo {
	
	//싱글톤
	static MemberInfo memberInfo = new MemberInfo();
	static MemberInfo getInstance() {
		return memberInfo;
	}
	private MemberInfo() {}
	String[] names = new String[10];
	
	void print() {
		//타입, 네임즈안에서 뽑아올 변수 name, 배열이름
		for(String name : names) {
			System.out.println(name);
		}
	}
}
