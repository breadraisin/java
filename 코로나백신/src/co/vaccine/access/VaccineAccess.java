package co.vaccine.access;

import java.util.ArrayList;

import co.vaccine.model.Vaccine;
import co.vaccine.model.Hospital;
import co.vaccine.model.Reservation;

public interface VaccineAccess {
	
	//회원 로그인
	public boolean logIn(String id, String pass);
	
	//회원가입
	public void signUp(Vaccine vaccine);
	
	//회원 예약
	//public boolean reserve(String h_address, String h_name);
	public ArrayList<Hospital> select(String h_address);
	public void insert(Reservation reserves);
	public Reservation selectRe(String u_name);
	//public Hospital selectAdd(String h_address);
	
	//관리자 로그인
	public boolean managerlogIn(String m_id, String m_pass);
	
	
	public ArrayList<Vaccine> selectAll();
	public void update(Vaccine vaccine);
	public void delete(String age);
	public Vaccine selectOne(String age);

	ArrayList<Reservation> selectAll2();
	
}
