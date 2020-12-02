package departmentApp.command.employee;


import departmentApp.command.Command;
import departmentApp.service.EmployeeService;
import departmentApp.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployee implements Command {

    private final EmployeeService employeeService = new EmployeeService();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer idEmployee = Utils.parseInteger(request.getParameter("id_employee"));
        employeeService.deleteEmployee(idEmployee);
        response.sendRedirect("listDepartment");
    }
}
