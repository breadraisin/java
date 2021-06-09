package co.friend.view;

import java.util.List;

import co.friend.access.FriendAccess;
import co.friend.access.FriendDAO;
import co.friend.access.FriendList;
import co.friend.model.Friend;
import co.friend.util.ScannerUtil;

public class FriendCliApp {
	
//	FriendList friendList = new FriendList();
	FriendAccess friendList = new FriendDAO();
	
	//프로그램 시작
	public void start() {
	int menunum;
	do {
		menuTitle(); //메뉴출력
		menunum = ScannerUtil.readInt("입력"); //메뉴 선택
		switch(menunum) { //실행
		case 1:	insert();		break;
		case 2:	update();		break;
		case 3:	delete();		break;
		case 4:	selectAll();	break;
		case 5:	findName();		break;
		case 6:	findTel();		break;
		}
	} while(menunum != 0);
}
	//메뉴출력
	public void menuTitle() {
		System.out.println("==친구  관리==");
		System.out.println("==1.친구추가==");
		System.out.println("==2.친구수정==");
		System.out.println("==3.친구삭제==");
		System.out.println("==4.전체조회==");
		System.out.println("==5.이름으로조회==");
		System.out.println("==6.전화번호 조회==");
		System.out.println("==0.종료==");
		
	}
	//등록
	public void insert() {
		Friend friend = ScannerUtil.readFriend(); 
		friendList.insert(friend);
	}
	//이름으로 검색해서 전화번호수정
	public void update() {
		Friend friend = new Friend();
		friend.setName(ScannerUtil.readStr("이름 입력"));
		friend.setTel(ScannerUtil.readStr("수정할 번호 입력"));
		friendList.update(friend);
	}
	
	//이름으로 검색해서 삭제 
	public void delete() {
		String name = ScannerUtil.readStr();
		friendList.delete(name);
	}
	
	//이름 검색
	public void findName() {
		String name = ScannerUtil.readStr();
		Friend friend = friendList.selectOne(name);
		System.out.println(friend);
	}
	
	//전체조회
	public void selectAll() {
		List<Friend>list = friendList.selectAll();
		for(Friend friend : list) {
			System.out.println(friend);
		}
	}
	
	//전화번호조회
	public void findTel() {
		String tel = ScannerUtil.readStr();
		Friend friend = friendList.findTel(tel);
		System.out.println(friend);
	}
}
	



