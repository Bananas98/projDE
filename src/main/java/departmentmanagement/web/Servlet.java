package departmentmanagement.web;

import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;
import departmentmanagement.model.Department;
import departmentmanagement.model.Employee;
import departmentmanagement.validate.DepartmentValidate;
import departmentmanagement.validate.EmployeeValidate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;



@WebServlet("/")
public class Servlet extends HttpServlet {
	EmployeeValidate employeeValidate = new EmployeeValidate();
	DepartmentValidate departmentValidate = new DepartmentValidate();
	private static final long serialVersionUID = 1L;
	private DepartmentDAO departmentDAO;
	private EmployeeDAO employeeDAO;
	boolean error=false;
	public void init() {
		departmentDAO = new DepartmentDAOImpl();
		employeeDAO = new EmployeeDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {

		case "/newDepartment":
			showNewFormDepartment(request, response);
			break;
		case "/editDepartment":
			showEditFormDepartment(request, response);
			break;
		case "/insertDepartment":
			insertDepartment(request, response);
			break;
		case "/deleteDepartment":
			deleteDepartment(request, response);
			break;
		case "/updateDepartment":
			updateDepartment(request, response);
			break;
		case "/listEmployee":
			getAllEmployee(request, response);
			break;
		case "/newEmployee":
			showNewFormEmployee(request, response);
			break;
		case "/editEmployee":
			showEditFormEmployee(request, response);
			break;
		case "/insertEmployee":
			insertEmployee(request, response);
			break;
		case "/deleteEmployee":
			deleteEmployee(request, response);
			break;
		case "/updateEmployee":
			updateEmployee(request, response);
			break;
		default:
			listDepartment(request, response);
			break;
		}
	}

	private void listDepartment(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Department> listDepartment = departmentDAO.getAllDepartments();
		request.setAttribute("listDepartment", listDepartment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("department-list.jsp");
		dispatcher.forward(request, response);
	}

	private void getAllEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int idDepartment = Integer.parseInt(request.getParameter("id_department"));
		String nameDepartment = departmentDAO.get(idDepartment).getName();
		List<Employee> listEmployee = employeeDAO.getAllEmployeeDepartments(idDepartment);
		request.setAttribute("listEmployee", listEmployee);
		request.setAttribute("id_department", idDepartment);
		request.setAttribute("name_department", nameDepartment);

		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("department-form.jsp");
		dispatcher.forward(request, response);
	}


	private void showNewFormEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_department = Integer.parseInt(request.getParameter("id_department"));
		String nameDepartment = departmentDAO.get(id_department).getName();
		List<Department> listDepartment = departmentDAO.getAllDepartments();
		request.setAttribute("listDepartment", listDepartment);
		request.setAttribute("id_department", id_department);
		request.setAttribute("name_department", nameDepartment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Department existingDepartment = departmentDAO.get(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("department-form.jsp");
		request.setAttribute("department", existingDepartment);
		dispatcher.forward(request, response);

	}


	private void showEditFormEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_employee"));
		Employee existingEmployee = employeeDAO.get(id);
		List<Department> listDepartment = departmentDAO.getAllDepartments();
		request.setAttribute("listDepartment", listDepartment);
		request.setAttribute("employee", existingEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);

	}

	private void insertDepartment(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String name = request.getParameter("name");
		departmentDAO.create(name);
		response.sendRedirect("list");
	}

	//Employee
	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String name = request.getParameter("name");
		Date dateOfBirthday = Date.valueOf(reverseDate(request.getParameter("dateOfBirthday")));
		String mail = request.getParameter("mail");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int idDepartment = Integer.parseInt(request.getParameter("id_department"));
		employeeDAO.create(name,dateOfBirthday,mail,salary,idDepartment);
		response.sendRedirect("listEmployee" +"?id_department="+ idDepartment);
	}

	private String reverseDate(String date){
		StringBuilder stringBuilder = new StringBuilder();
		String [] arr = date.split("\\.");
		for (int i = arr.length-1; i >= 0; i--) {
			stringBuilder.append(arr[i]).append("-");
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		return stringBuilder.toString();
	}

	private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		departmentDAO.update(id,name);
		response.sendRedirect("list");
	}

	//Employee
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Date dateOfBirthday = Date.valueOf(request.getParameter("dateOfBirthday"));
		String mail = request.getParameter("mail");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int idDepartment = Integer.parseInt(request.getParameter("id_department"));
		employeeDAO.update(id,name,dateOfBirthday,mail,salary,idDepartment);
		response.sendRedirect("listEmployee" +"?id_department="+ idDepartment);
	}


	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		departmentDAO.delete(id);
		response.sendRedirect("list");
	}

	//Employee
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int idEmployee = Integer.parseInt(request.getParameter("id_employee"));
		employeeDAO.delete(idEmployee);
		response.sendRedirect("list");
	}


}
