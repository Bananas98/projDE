package departmentmanagement.command.delete;



import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployee implements Command {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEmployee = Integer.parseInt(request.getParameter("id_employee"));
        employeeDAO.delete(idEmployee);
        response.sendRedirect("listDepartment");
    }
}
