package pkg.friend;

import pkg.Friend;

public class AppMain {
	public static void main(String[] args) {
		 //인터페이스 직접 생성 못함 
		//FriendAccess manager = BeanFactory.getBean(FriendAccess.class)//new FriendList();
		Friend f = new CompanyFriend("학교","홍길동","111","과장");
		f.print();
		
		Friend f1 = new SchoolFriend("학교","홍길동","111","1101");
		f1.print();
		//다형성(상속받고 오버라이딩)
		//1.부모타입의 참조변수가 자식객체를 참조가능
		//2.메서드 실행하면 참조대상의 메서드가 호출되므로 결과가 다르다 

		FriendManager manager = new FriendManager();
		for(Friend fr : manager.friends) {
			if(fr instanceof SchoolFriend)
				fr.print();
		}
		
	}		
		
}
;