package departmentmanagement.command.employeeCommand;



import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;
import departmentmanagement.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployee implements Command {

    private EmployeeService employeeService = new EmployeeService();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEmployee = Integer.parseInt(request.getParameter("id_employee"));
        employeeService.deleteEmployee(idEmployee);
        response.sendRedirect("listDepartment");
    }
}
