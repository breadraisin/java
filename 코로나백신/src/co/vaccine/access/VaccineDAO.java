package co.vaccine.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.vaccine.model.Vaccine;

public class VaccineDAO implements VaccineAccess {

	PreparedStatement psmt;
	ResultSet rs;
	static Connection conn;
	
	//회원가입
	@Override
	public void signUp(Vaccine vaccine) {
		connect();
		try {
			psmt = conn.prepareStatement("insert into vaccineInfo(id,pass,name,age,address,phone,type) values (?,?,?,?,?,?,?)");
			psmt.setString(1, vaccine.getId());
			psmt.setString(2, vaccine.getPass());
			psmt.setString(3, vaccine.getName());
			psmt.setString(4, vaccine.getAge());
			psmt.setString(5, vaccine.getAddress());
			psmt.setString(6, vaccine.getPhone());
			psmt.setString(7, vaccine.getType());
			int r = psmt.executeUpdate();
			System.out.println("입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//회원 로그인
	public boolean logIn(String id, String pass) {
		connect();
		boolean log = false;
		try {
			psmt = conn.prepareStatement("select * from vaccineInfo where id =? and pass = ?");
			psmt.setString(1, id);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			if (rs.next()) {
				log = true;
			} else {
				log = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return log;
	}
	
	//관리자 로그인
	@Override
	public boolean managerlogIn(String m_id, String m_pass) {
		connect();
		boolean log2 = false;
		try {
			psmt = conn.prepareStatement("select * from manager where m_id =? and m_pass = ?");
			psmt.setString(1, m_id);
			psmt.setString(2, m_pass);
			rs = psmt.executeQuery();
			if (rs.next()) {
				log2 = true;
			} else {
				log2 = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return log2;
	}
	
	@Override
	public ArrayList<Vaccine> selectAll() {
		connect();
		ArrayList<Vaccine> vList = new ArrayList<Vaccine>();
		try {
			psmt = conn.prepareStatement("select * from vaccineInfo");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Vaccine vaccine = new Vaccine();
				vaccine.setName(rs.getString("name"));
				vaccine.setAge(rs.getString("age"));
				vaccine.setPhone(rs.getString("phone"));
				vaccine.setType(rs.getString("type"));
				vList.add(vaccine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vList;                                                  
	}

	@Override
	public void update(Vaccine vaccine) {
		connect();
		try {
			psmt = conn.prepareStatement("update vaccineInfo set type = ? where name = ? and age = ?");
			psmt.setString(1, vaccine.getType());
			psmt.setString(2, vaccine.getName());
			psmt.setString(3,vaccine.getAge());
			int r = psmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String age) {
		try {
			psmt = conn.prepareStatement("delete from vaccineInfo where age=?");
			psmt.setString(1, age);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Vaccine selectOne(String age) {
		Vaccine v = null;
		try {
			psmt = conn.prepareStatement("select * from vaccineInfo where age = ?");
			psmt.setString(1, age);
			rs = psmt.executeQuery();
			while(rs.next()) {
				v = new Vaccine();
				v.setName(rs.getString("name"));
				v.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;              
	}
	
	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("<<<연결 성공>>>");
		} catch (SQLException e) {
			System.out.println("<<<연결 실패>>>");
		}
	}

	

	

	

	
	
}
