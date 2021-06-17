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
	
	//관리자 로그인
	public boolean managerlogIn(String m_id, String m_pass);
	
	//예약병원조회
	public ArrayList<Hospital> select(String h_address);
	
	//예약입력
	public void insert(Reservation reserves);
	
	//예약조회
	public Reservation selectRe(String u_name);
	
	//병원등록
	public void insert2(Hospital hospital);
	
	//병원수정
	public void update2(Hospital hospital); 
	
	//병원리스트
	public ArrayList<Hospital> selecth();
	
	//회원리스트
	public ArrayList<Vaccine> selectAll();

	//회원검색
	public Vaccine selectOne(String age);
	
	//회원삭제
	public void delete(String age);

	//예약리스트
	public ArrayList<Reservation> selectAll2();

	public Vaccine selectage(String id);
	
	
	
	//public void update(Vaccine vaccine);
	//public Hospital selectAdd(String h_address);
	//public boolean reserve(String h_address, String h_name);
	
}
