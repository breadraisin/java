package co.yedam.emp;

public class Employee {
	int employeeId; 		//사번
	String name; 			//이름
	int departmentId; 		//부서번호  10:인사, 20:개발, 30:영업(기본값)
	String departmentName;   //부서명
	int salary; 			//급여
	String email; 			//이메일
	
	Employee(int employeeId, String name){
		this(employeeId,name,0,0,"");
	}
	
	Employee(int employeeId, String name, String email){
		this(employeeId,name,0,0,email);
	}
	
	Employee(int employeeId, String name, int salary){
		this(employeeId,name,0,salary,"");
	}
	Employee(){
		this(105,"김나연",10,2500,"s@a.c");
	}
	
	
	public Employee(int employeeId, String name, int departmentId, int salary, String email) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.departmentId=departmentId;

		if(this.departmentId == 0) 
			this.departmentId = 30;
		
		if(this.departmentId == 10) {
			this.departmentName = "인사";
		}else if(this.departmentId == 20){
			this.departmentName = "개발";
		}else if (this.departmentId == 30){
			this.departmentName = "영업";
		}
	
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", salary=" + salary + ", email=" + email + "]";
	}


	
	
	
	
	
}

	