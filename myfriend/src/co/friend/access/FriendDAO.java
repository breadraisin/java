package co.friend.access;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.friend.model.Friend;
//FriendAccess.java, FriendList.java
import co.friend.util.DAO;

//프렌드엑세스를 구현하는 구현 클래스
public class FriendDAO extends DAO implements FriendAccess { //프렌드엑세스에 선언만 되어있는 추상메서드를 여기서 구현하겠다. 
	
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	//name,tel 값을 담아주는 컬렉션
	public Map<String, String> getNameTel(){
		
		Map<String, String> info = new HashMap<>();
		
		try {
			psmt = conn.prepareStatement("select name, tel from friend");
			rs = psmt.executeQuery();
			while(rs.next()) {
				info.put(rs.getString("name"), rs.getString("tel"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return info;
	}
	
	
	@Override
	public void insert(Friend friend) {
		//입력
		try {
			psmt = conn.prepareStatement("insert into friend values(?,?,?)");
			psmt.setString(1, friend.getGubun());
			psmt.setString(2, friend.getName());
			psmt.setString(3, friend.getTel());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void update(Friend friend) {
		//구분,이름,전화
		//동일한 이름은 없다는 전제 
		//where name=? 
		try {
			psmt = conn.prepareStatement("update friend set tel=? where name=? ");
			psmt.setString(1,friend.getTel());
			psmt.setString(2,friend.getName());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void delete(String name) {
		String sql = "delete from friend where name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			System.out.println(r + "삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ArrayList<Friend> selectAll() {
		ArrayList<Friend> fList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from friend");
			rs = psmt.executeQuery();  //위 결과값을 여기에 담겠다.
			while(rs.next()) {
				Friend friend = new Friend();
				friend.setGubun(rs.getString("gubun")); //프렌드셋구분에는 결과값의 구분값을 넣겟슴니다.
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
				fList.add(friend); // 데이터건수만큼 arrayList 담아서 변환 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fList;
	}

	@Override
	public Friend selectOne(String name) {
		Friend f = null;
		String sql = "select * from friend where name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			while(rs.next()) {
			 f = new Friend();
			 f.setGubun(rs.getString("gubun"));
			 f.setName(rs.getString("name"));
			 f.setTel(rs.getString("tel"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f; 
	}

	@Override
	public Friend findTel(String tel) {
		Friend f = null;
		String sql = "select * from friend where tel = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, tel);
			rs = psmt.executeQuery();
			while(rs.next()) {
			 f = new Friend();
			 f.setGubun(rs.getString("gubun"));
			 f.setName(rs.getString("name"));
			 f.setTel(rs.getString("tel"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f; 
	}

}
