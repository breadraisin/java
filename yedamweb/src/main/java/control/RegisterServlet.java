package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmpDAO;
import common.Employee;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			
		throws ServletException, IOException {
		
		String eid = request.getParameter("eid");
		String last_name = request.getParameter("last_name");
		String em = request.getParameter("email");
		String hd = request.getParameter("hire_date");
		String fn = request.getParameter("first_name");
		
		
		EmpDAO dao = new EmpDAO();
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(eid));
		emp.setLastName(last_name);
		emp.setFirstName(fn);
		emp.setEmail(em);
		emp.setHireDate(hd);
		
		dao.insertEmp(emp);
		
		//{"id":?,"first_name":?, "last_name":?, "email":?, "hire_date":?}
		PrintWriter out = response.getWriter();
		out.println("{\"id\":"+emp.getEmployeeId()
					+",\"first_name\":\""+emp.getFirstName()
					+"\", \"last_name\":\""+emp.getLastName()
					+"\", \"email\":\""+emp.getEmail()
					+"\", \"hire_date\":\""+emp.getHireDate()+"\"}");
		
		//System.out.println(eid+","+last_name+","+em+","+hd+","+fn);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
