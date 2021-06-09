package co.friend.common;

import co.friend.access.FriendDAO;

public class CollectionEx4 {

	public static void main(String[] args) {
		//이름, 연락처를 출력하세요.
		
		FriendDAO dao = new FriendDAO();
		dao.getNameTel();
		System.out.println(dao.getNameTel());
	}

}
