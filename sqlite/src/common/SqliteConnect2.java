package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SqliteConnect2 {
	// 필드로 선언
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	// 1.조회 2.입력 3.수정 4.삭제 5.전체리스트(각각 기능을 분리) 6.이름조회 => 메소드로 기능분리.

	// 전체리스트
	public static ArrayList<Person> getPersonList() { // 리턴값은 어레이리스트네~~
		ArrayList<Person> personList = new ArrayList<>();
		connect(); // Connection 객체 연결
		String sql = "select * from person";
		try {
			psmt = conn.prepareStatement(sql); // PreparedStatement 쿼리를 실행. 결과를 받아오는 역할
			rs = psmt.executeQuery(); // 쿼리실행결과를 가져오는 부분.
			while (rs.next()) {
				// System.out.println(rs.getInt("id") + rs.getString("name"));
				Person person = new Person(); // person 이라는 필드에 sql을 담으려고
				person.setId(rs.getInt("id")); // rs의 id값을 인트값으로 받아와서 펄슨의 셋아이디로 ?
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));
				personList.add(person); // 펄슨을 최종적으로 펄슨리스트에 담는다.

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return personList;
	}

	// 한건조회
	public static Person getPerson(int id) {
		connect();
		String sql = "select * from person where id = ?";
		Person p = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id); // ?에 값 대입
			rs = psmt.executeQuery(); // selectquery
			if (rs.next()) {
				p = new Person(); // instance를 생성하고 변수 p에 대입.
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // PreparedStatement 객체 생성.
		finally {
			close();
		}
		return p;
	}
	


	// 입력기능
	public static void insertPerson(int id, String name, int age, String phone) { // ()얘네를 받아오겠다
		connect();
		String sql = "insert into person values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id); // 첫번쨰 아이디값을 첫번쨰 ?에 넣겟다
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setString(4, phone);
			int r = psmt.executeUpdate(); // insert, update, delete 할 때 사용.
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	// 수정기능
	public static void updatePerson(Person p) {
		connect();
		String sql = "update person set name =?,age=?,phone=? where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p.getName());
			psmt.setInt(2, p.getAge());
			psmt.setString(3, p.getPhone());
			psmt.setInt(4, p.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	
	}
	
	// 삭제기능
	public static void deletePerson(int id) {
		connect();
		String sql = "delete from person where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);		
			int r = psmt.executeUpdate(); // insert, update, delete 할 때 사용.
			System.out.println(r + "삭제되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	//이름조회
	public static ArrayList<Person> getPersonList(String name) { 
		ArrayList<Person> personList = new ArrayList<>();
		connect(); // Connection 객체 연결
		String sql = "select * from person where name = ? ";
		try {
			psmt = conn.prepareStatement(sql); // PreparedStatement 쿼리를 실행. 결과를 받아오는 역할
			psmt.setString(1, name);
			rs = psmt.executeQuery(); // 쿼리실행결과를 가져오는 부분.
			while (rs.next()) {
				// System.out.println(rs.getInt("id") + rs.getString("name"));
				Person person = new Person(); // person 이라는 필드에 sql을 담으려고
				person.setId(rs.getInt("id")); // rs의 id값을 인트값으로 받아와서 펄슨의 셋아이디로 ?
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));
				personList.add(person); // 펄슨을 최종적으로 펄슨리스트에 담는다.

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return personList;
	}
	

	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/dd.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void close() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} if(psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1:전체리스트 2:입력 3:수정 4:삭제 5:한건조회 6.이름조회 9:종료");
			int menu = scn.nextInt();
			if (menu == 1) {
				// 전체리스트 기능
				System.out.println("조회 결과>");
				ArrayList<Person> list = getPersonList();
				for (Person person : list) { // list 에 들은 펄슨 개수만큼 반복
					System.out.println(person);
				}

			} else if (menu == 2) {
				// 입력기능
				System.out.println("아이디를 입력하세요");
				int searchId = scn.nextInt();
				scn.nextLine();
				System.out.println("이름을 입력하세요");
				String name = scn.nextLine();
				System.out.println("나이를 입력하세요");
				int age = scn.nextInt();
				scn.nextLine();
				System.out.println("전화번호를 입력하세요");
				String phone = scn.nextLine();

				insertPerson(searchId, name, age, phone);

			} else if (menu == 3) {
				System.out.println("수정할 아이디를 입력하세요.");
				int searchId = scn.nextInt();
				scn.nextLine();
				Person p = getPerson(searchId); // p=>id,name,age,phone
				
				if(p==null) { //조회아이디가 존재 x
					System.out.println("존재하지 않는 아이디");
					continue;
				}
				
				System.out.println("변경할 이름:");
				String changedName = scn.nextLine();
				System.out.println("변경할 나이:");
				String changedAge = scn.nextLine();
				System.out.println("변경할 전화번호:");
				String changedPhone = scn.nextLine();
				
				if(!changedName.equals("")) {
					p.setName(changedName);
				}
				if(!changedAge.equals("")) {
					p.setAge(Integer.parseInt(changedAge));
				}
				if(!changedPhone.equals("")) {
					p.setPhone(changedPhone);
				}
				
				updatePerson(p);
				
			} else if (menu == 4) {
				System.out.println("삭제할 아이디를 입력하세요");
				int searchId = scn.nextInt();
				deletePerson(searchId);
			} else if (menu == 5) {
				// 한건조회
				System.out.println("조회할 아이디를 입력하세요");
				int searchId = scn.nextInt();
				Person p = getPerson(searchId);
				if (p == null) {
					System.out.println("조회된 값이 없습니다.");
				} else {
					System.out.println(p);
				}
			} else if (menu == 6) {
				System.out.println("조회할 이름을 입력하세요");
				String name = scn.next();
				ArrayList<Person> list = getPersonList(name);
				for (Person person : list) { // list 에 들은 펄슨 개수만큼 반복
					System.out.println(person);
				}
			}
			else if (menu == 9) {
				break;
			}
		} // end of while
		
		scn.close();
		System.out.println("정상적인 종료");
	} // end of main()
} // end of class
