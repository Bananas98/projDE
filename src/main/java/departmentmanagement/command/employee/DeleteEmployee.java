package departmentmanagement.command.employee;


import departmentmanagement.command.Command;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteEmployee implements Command {

    private final EmployeeService employeeService = new EmployeeService();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Integer idEmployee = Utils.parseInteger(request.getParameter("id_employee"));
        employeeService.deleteEmployee(idEmployee);
        response.sendRedirect("listDepartment");
    }
}
