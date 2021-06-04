package co.friend.access;
/**
 * 인터페이스 : 상수필드 + 추상메서드 
 * 상수필드 : public static final
 * 메서드 : public abstract 
 */


import java.util.ArrayList;

import co.friend.model.Friend;

// 친구관리개발 시 개발 표준 
public interface FriendAccess {
	
	//등록
	public void insert(Friend friend);
	//수정
	public void update(Friend friend);
	//삭제
	public void delete(String name);
	//전체조회
	public ArrayList<Friend> selectAll();
	//단건조회
	public Friend selectOne(String name);
	//전화번호조회
	public Friend findTel(String tel);
	
	
}
