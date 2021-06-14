package co.vaccine.access;

import java.util.ArrayList;

import co.vaccine.model.Vaccine;

public interface VaccineAccess {
	
	
	public boolean logIn(String id, String pass);
	public void signUp(Vaccine vaccine);
	public boolean managerlogIn(String m_id, String m_pass);
	
	
	public ArrayList<Vaccine> selectAll();
	public void update(Vaccine vaccine);
	public void delete(String age);
	public Vaccine selectOne(String age);
	
}
