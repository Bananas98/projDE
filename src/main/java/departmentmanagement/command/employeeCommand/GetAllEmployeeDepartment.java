package departmentmanagement.command.employeeCommand;



import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllEmployeeDepartment implements Command {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDepartment = Integer.parseInt(request.getParameter("id_department"));
        String nameDepartment = departmentDAO.get(idDepartment).getName();
        List<Employee> listEmployee = employeeDAO.getAllEmployeeDepartments(idDepartment);
        request.setAttribute("listEmployee", listEmployee);
        request.setAttribute("id_department", idDepartment);
        request.setAttribute("name_department", nameDepartment);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employee-list.jsp");
        dispatcher.forward(request, response);
    }
}
