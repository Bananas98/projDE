package departmentmanagement.command.employee;


import departmentmanagement.command.Command;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(value = "/deleteEmployee")
public class DeleteEmployee implements Command {

    @Autowired
    private EmployeeService employeeService;


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer idEmployee = Utils.parseInteger(request.getParameter("id_employee"));
        employeeService.deleteEmployee(idEmployee);
        response.sendRedirect("listDepartment");
    }
}
