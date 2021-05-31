package co.yedam.member;

import java.util.Scanner;

public class MemberService {
	Member[] members = new Member[10];
	int cnt = 0;
	Scanner scanner = new Scanner(System.in);

	//회원가입
	void insert(String id, String password, String name, int age) {
		members[cnt] = new Member(id,password,name,age);
		cnt++;
	} 
	void insert() {
		String id = scanner.next();
		String password = scanner.next();
		String name = scanner.next();
		int age = scanner.nextInt();
		
		members[cnt] = new Member(name,id,password,age);
		cnt++;
	} 
	//회원리스트
	void printList() {
		for(int i=0;i<=cnt-1;i++) {
		System.out.println("회원리스트:"+members[i]);
		}
	}
	
	void printMember(int i) {
		System.out.println(members[i].name);
		System.out.println(members[i].id);
		System.out.println(members[i].age);
	}
	
	
	boolean login(){
		
		String id = scanner.next();
		String password = scanner.next();
		for(int i=0;i<cnt;i++) {
			if(id.equals(members[i].id) && password.equals(members[i].password)) {
				System.out.println("로그인 성공");
				return true; 

				} 
			}System.out.println("로그인 실패");
			return false;
	}
	
	boolean login(String id, String password){
		
		for(int i=0;i<cnt;i++) {
		if(id.equals(members[i].id) && password.equals(members[i].password)) {
			return true;
			} 
		}
		return false;
	}
	

	void logout(String id){
		System.out.println("로그아웃 되었습니다");
	}
}

