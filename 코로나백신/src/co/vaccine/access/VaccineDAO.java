package co.vaccine.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.vaccine.model.Vaccine;
import co.vaccine.model.Hospital;
import co.vaccine.model.Reservation;

public class VaccineDAO implements VaccineAccess {

	PreparedStatement psmt;
	ResultSet rs;
	static Connection conn;
	
	//회원가입
	@Override
	public void signUp(Vaccine vaccine) {
		connect();
		try {
			psmt = conn.prepareStatement("insert into vaccineInfo(id,pass,name,age,address,phone) values (?,?,?,?,?,?)");
			psmt.setString(1, vaccine.getId());
			psmt.setString(2, vaccine.getPass());
			psmt.setString(3, vaccine.getName());
			psmt.setString(4, vaccine.getAge());
			psmt.setString(5, vaccine.getAddress());
			psmt.setString(6, vaccine.getPhone());
			int r = psmt.executeUpdate();
			System.out.println("입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
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
		} finally {
			close();
		}
		return log;
	}
	
	//병원 조회
	@Override
	public ArrayList<Hospital> select(String h_address) {
		connect();
		ArrayList<Hospital> hList = new ArrayList<Hospital>();
		try {
			psmt = conn.prepareStatement("select * from hospital where h_address = ?");
			psmt.setString(1, h_address);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Hospital hospital = new Hospital();
				hospital.setH_id(rs.getInt("h_id"));
				hospital.setH_address(rs.getString("h_address"));
				hospital.setH_name(rs.getString("h_name"));
				hList.add(hospital);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return hList;              
	}
	
	//병원 예약
	public void insert(Reservation reserves) {
		connect();
		try {
			psmt = conn.prepareStatement("insert into reservation(h_name,u_name,day) values (?,?,?)");
			psmt.setString(1, reserves.getH_name());
			psmt.setString(2, reserves.getU_name());
			psmt.setString(3, reserves.getDay());
			int r = psmt.executeUpdate();
			System.out.println("예약되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	//예약 조회
	@Override
	public Reservation selectRe(String u_name) {
		connect();
		Reservation re = null;
		try {
			psmt = conn.prepareStatement("select * from reservation where u_name = ?");
			psmt.setString(1, u_name);
			rs = psmt.executeQuery();
			while(rs.next()) {
				re = new Reservation();
				re.setH_name(rs.getString("h_name"));
				re.setU_name(rs.getString("u_name"));
				re.setDay(rs.getString("day"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return re;              
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
		} finally {
			close();
		}
		return log2;
	}
	
	@Override
	public ArrayList<Reservation> selectAll2() {
		connect();
		ArrayList<Reservation> rList = new ArrayList<Reservation>();
		try {
			psmt = conn.prepareStatement("select * from reservation");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Reservation reserves = new Reservation();
				reserves.setH_name(rs.getString("h_name"));
				reserves.setU_name(rs.getString("u_name"));
				reserves.setDay(rs.getString("day"));
				rList.add(reserves);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return rList;                                                  
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
		}finally {
			close();
		}
		return vList;                                                  
	}
	
	@Override
	public void update(Vaccine vaccine) {
		connect();
		try {
			psmt = conn.prepareStatement("update vaccineInfo set type = ? where age = ?");
			psmt.setString(1, vaccine.getType());
			psmt.setString(2,vaccine.getAge());
			int r = psmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	@Override
	public void delete(String age) {
		connect();
		try {
			psmt = conn.prepareStatement("delete from vaccineInfo where age=?");
			psmt.setString(1, age);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	@Override
	public Vaccine selectOne(String age) {
		connect();
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
		}finally {
			close();
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
	
	// close
	public void close() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(psmt!=null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	
}

	

