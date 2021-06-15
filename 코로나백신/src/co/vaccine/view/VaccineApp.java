package co.vaccine.view;

import java.util.List;
import java.util.Scanner;

import co.vaccine.access.VaccineAccess;
import co.vaccine.access.VaccineDAO;
import co.vaccine.model.Vaccine;
import co.vaccine.model.Hospital;
import co.vaccine.model.Reservation;

public class VaccineApp {
	
	Scanner scanner = new Scanner(System.in);
	VaccineAccess dao = new VaccineDAO();

	public void start() {
		int menuNum;
		do {
			System.out.println("----------------------");
			System.out.println("|   1. 로그인          |");
			System.out.println("|   2. 회원가입         |");
			System.out.println("|   3. 관리자 로그인     |");
			System.out.println("|   0. 종료            |");
			System.out.println("----------------------");
			System.out.print("메뉴 번호 입력 > ");
			menuNum = scanner.nextInt();
			switch (menuNum) {
				case 1: logIn();	
				break;
				case 2: signUp();	
				break;
				case 3: managerlogIn();	
				break;
			}
		} while (menuNum != 0);
		System.out.println("종료");
	}

	public void menu() {
		int menuNum;

		do {
			menuTitle1();
			System.out.print("입력> ");
			menuNum = scanner.nextInt();
			scanner.nextLine();
			switch (menuNum) {
			case 1:
				reserve();
				break;
			case 2:
				selectRe();
				break;
			}
		} while (menuNum != 0);
		System.out.println("프로그램 종료.");
	}
	
	public void menu2() {
		int menuNum;

		do {
			menuTitle2();
			System.out.print("입력> ");
			menuNum = scanner.nextInt();
			scanner.nextLine();
			switch (menuNum) {
			case 1:
				selectAll();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				selectAll2();
				break;

			}
		} while (menuNum != 0);
		System.out.println("프로그램 종료.");
	}
	
	private void logIn() {
		System.out.println("1. 로그인");
		System.out.println("아이디 > ");
		String id = scanner.next();
		System.out.println("비밀번호 > ");
		String pass = scanner.next();
		boolean log = dao.logIn(id, pass);
		if (log==true) {
			menu();
		} else {
			System.out.println("아이디와 비밀번호를 다시 확인하세요.");
			start();
		}
	}

	private void signUp() {
		System.out.println("2. 회원가입");
		System.out.println("아이디 입력>");
		String id = scanner.next();
		System.out.println("비밀번호 입력>");
		String pass = scanner.next();
		System.out.println("이름 입력>");
		String name = scanner.next();
		System.out.println("주민번호 앞자리 입력>");
		String age = scanner.next();
		System.out.println("주소 입력>");
		String address = scanner.next();
		System.out.println("폰번호 입력>");
		String phone = scanner.next();
		
		Vaccine vaccine = new Vaccine(id,pass,name,age,address,phone);
		dao.signUp(vaccine);
		
	}
	
	private void managerlogIn() {
		System.out.println("3. 관리자 로그인");
		System.out.println("아이디 > ");
		String m_id = scanner.next();
		System.out.println("비밀번호 > ");
		String m_pass = scanner.next();
		boolean log2 = dao.managerlogIn(m_id, m_pass);
		if (log2==true) {
			menu2();
		} else {
			System.out.println("아이디와 비밀번호를 다시 확인하세요.");
			start();
		}
	}

	private void reserve() {
		String type;
		String type2 = "아니오";
		System.out.println("백신 1차접종을 하셨습니까? [네/아니오] >");
		type = scanner.nextLine();
		
		if(type.equals(type2)){
			select();
			insert();
			
		} else {
			System.out.println("2차 접종");
		}
	}
	
	private void insert() {
		
		System.out.println("병원 입력>");
		String h_name = scanner.next();
		System.out.println("이름 입력>");
		String u_name = scanner.next();
		System.out.println("날짜 입력>");
		String day = scanner.next();
		
		Reservation reserve = new Reservation(h_name,u_name,day);
		dao.insert(reserve);		
	}
	
	// 주민번호로 조회
	private void selectRe() {
		System.out.println("이름 입력>");
		String u_name = scanner.next();
		Reservation reserve = dao.selectRe(u_name);
		System.out.println(reserve);
	}

		// 병원 조회
		private void select() {
			System.out.println("지역 입력>");
			String  h_address = scanner.next();
			List<Hospital> hlist = dao.select(h_address);
			for(Hospital hospital : hlist) {
			System.out.println(hospital);
			}
		}
	
	// 회원 수정
	private void update() {
		Vaccine vaccine = new Vaccine();
		System.out.println("주민번호 앞자리 입력>");
		vaccine.setAge(scanner.next());
		System.out.println("백신 접종 여부 입력>");
		vaccine.setType(scanner.next());
		dao.update(vaccine);
	}

	// 회원 전체 조회
	private void selectAll() {
		List<Vaccine>list = dao.selectAll();
		for(Vaccine vaccine : list) {
			System.out.println(vaccine);
		}
	}

	// 회원삭제
	private void delete() {
		System.out.println("삭제할 환자 주민번호 앞자리 입력>");
		String age = scanner.next();
		dao.delete(age);
	}
	
	private void selectAll2() {
		List<Reservation>list = dao.selectAll2();
		for(Reservation reserves : list) {
			System.out.println(reserves);
		}
	}
	
//	// 주민번호로 조회
//	private void selectOne() {
//		System.out.println("접종여부조회할 주민번호 입력>");
//		String age = scanner.next();
//		Vaccine vaccine = dao.selectOne(age);
//		System.out.println(vaccine);
//	}
	
	// 회원페이지
	private void menuTitle1() {
		System.out.println("----------------------");
		System.out.println("|  1. 접종 예약        |");
		System.out.println("|  2. 예약 조회	     |");
		System.out.println("|  0. 종료            |");
		System.out.println("----------------------");
	
	}
	
	// 관리자페이지
	private void menuTitle2() {
		System.out.println("----------------------");
		System.out.println("|  1. 회원정보	         |");
		System.out.println("|  2. 접종 여부	     |");
		System.out.println("|  3. 삭제            |");
		System.out.println("|  4. 예약전체조회         |");
		System.out.println("|  0. 종료            |");
		System.out.println("----------------------");
	
	}
}
