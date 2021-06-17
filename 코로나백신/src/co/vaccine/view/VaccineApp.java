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
	String id;
	String a;

	public void start() {
		int menuNum;
		do {
			System.out.println();
			System.out.println("<간단한 접종관리프로그램>");
			System.out.println();
			System.out.println("┌─────────────────────┐");
			System.out.println("|    1. 로그인	      |");
			System.out.println("|    2. 회원가입	      |");
			System.out.println("|    3. 관리자 로그인    |");
			System.out.println("|    0. 종료           |");
			System.out.println("└─────────────────────┘");
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
				insert2();
				break;
			case 2:
				update2();
				break;
			case 3:
				selecth();
				break;
			case 4:
				selectAll();
				break;
			case 5:
				selectOne();
				break;
			case 6:
				delete();
				break;
			case 7:
				selectAll2();
				break;
		

			}
		} while (menuNum != 0);
		System.out.println("프로그램 종료.");
	}
	
	//로그인
	private void logIn() {
		System.out.println("1. 로그인");
		System.out.println("아이디 > ");
		id = scanner.next();
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
	
	//회원가입
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
	
	//관리자 로그인
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
	
	// 회원페이지
		private void menuTitle1() {
			System.out.println("┌────────────────────┐");
			System.out.println("|  1. 예약            |");
			System.out.println("|  2. 예약 조회        |");
			System.out.println("|  0. 종료            |");
			System.out.println("└────────────────────┘");
		}
		
		//나이값만 가져오기
				private void selectage() {
					Vaccine age = dao.selectage(id);
					//System.out.println(age.getAge());
					a = age.getAge();	
				}
	
	//예약
	private void reserve() {
		String type;
		String type1 = "네";
		String type2 = "아니오";
		System.out.println("백신 1차접종을 하셨습니까? [네/아니오] >");
		type = scanner.nextLine();
		selectage();
		int i = Integer.parseInt(a.substring(0,2));
		System.out.println(i);
		
		if(type.equals(type2) && (121-i > 60)){ 
			select();
			insert();
			
		} else if (type.equals(type1)) { System.out.println("2차 접종 준비중..");
			
		} else {System.out.println("60대 이하는 하반기부터 접종 예약입니다.");}
	}
	
	//예약 입력
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
	
	// 예약 주민번호로 조회
	private void selectRe() {
		System.out.println("이름 입력>");
		String u_name = scanner.next();
		Reservation reserve = dao.selectRe(u_name);
		System.out.println(reserve);
	}

	// 예약 병원 조회
	private void select() {
		System.out.println("지역 입력>");
		String  h_address = scanner.next();
		List<Hospital> hlist = dao.select(h_address);
		for(Hospital hospital : hlist) {
		System.out.println(hospital);
		}
	}
	
	// 관리자페이지
	private void menuTitle2() {
		System.out.println("┌───────────────────────┐");
		System.out.println("|  1. 병원등록     	|");
		System.out.println("|  2. 병원수정	        |");
		System.out.println("|  3. 병원리스트     	|");
		System.out.println("|───────────────────────|");
		System.out.println("|  4. 회원리스트     	|");
		System.out.println("|  5. 회원검색     	|");
		System.out.println("|  6. 회원삭제     	|");
		System.out.println("|  7. 예약리스트     	|");
		System.out.println("|  0. 종료          	|");
		System.out.println("└───────────────────────┘");
	
	}
	
	//병원등록
	private void insert2() {
		System.out.println("지역 입력>");
		String h_address  = scanner.next();
		System.out.println("병원 입력>");
		String h_name = scanner.next();
		System.out.println("번호 입력>");
		String h_phone = scanner.next();
		
		Hospital hospital = new Hospital(h_address,h_name,h_phone);
		dao.insert2(hospital);		
	}
	
	//병원수정
	private void update2() {
		Hospital hospital = new Hospital();
		System.out.println("병원 입력>");
		hospital.setH_name(scanner.next());
		System.out.println("번호 입력>");
		hospital.setH_phone(scanner.next());
		dao.update2(hospital);
	}
	
	//병원리스트
	private void selecth() {
		List<Hospital>list = dao.selecth();
		for(Hospital hospital : list) {
			System.out.println(hospital);
		}
	}
	
	// 회원리스트
	private void selectAll() {
		List<Vaccine>list = dao.selectAll();
		for(Vaccine vaccine : list) {
			System.out.println(vaccine);
		}
	}
	
	// 회원검색
		private void selectOne() {
			System.out.println("회원 주민번호앞자리 입력>");
			String age = scanner.next();
			Vaccine vaccine = dao.selectOne(age);
			System.out.println(vaccine);
		}
		
	// 회원삭제
		private void delete() {
			System.out.println("삭제할 환자 주민번호 앞자리 입력>");
			String age = scanner.next();
			dao.delete(age);
		}
		
	//예약리스트
		private void selectAll2() {
			List<Reservation>list = dao.selectAll2();
			for(Reservation reserves : list) {
			System.out.println(reserves);
			}
		}
		
	
		
		
//  	회원수정
//  	private void update() {
//			Vaccine vaccine = new Vaccine();
//			System.out.println("주민번호 앞자리 입력>");
//			vaccine.setAge(scanner.next());
//			System.out.println("백신 접종 여부 입력>");
//			vaccine.setType(scanner.next());
//			dao.update(vaccine);
//		}

 
      

		
		
	
	
	
	
	
	
	
	
}
