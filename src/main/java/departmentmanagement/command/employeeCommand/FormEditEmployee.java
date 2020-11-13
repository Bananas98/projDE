package departmentmanagement.command.employeeCommand;

import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;
import departmentmanagement.model.Department;
import departmentmanagement.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FormEditEmployee implements Command {

    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_employee"));
        Employee existingEmployee = employeeDAO.get(id);
        List<Department> listDepartment = departmentDAO.getAllDepartments();
        request.setAttribute("listDepartment", listDepartment);
        request.setAttribute("employee", existingEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employee-form.jsp");
        dispatcher.forward(request, response);
    }
}
