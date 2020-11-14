package departmentmanagement.command.employeeCommand;


import departmentmanagement.command.Command;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CreateUpdateEmployee implements Command {

    private EmployeeService employeeService = new EmployeeService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setDateOfBirthday(Date.valueOf(request.getParameter("dateOfBirthday")));
        employee.setMail(request.getParameter("mail"));
        employee.setSalary(Utils.parseInteger(request.getParameter("salary")));
        employee.setIdDepartment(Utils.parseInteger(request.getParameter("id_department")));

        if (request.getParameter("id") != null) {
            employee.setId(Integer.parseInt(request.getParameter("id")));
            employeeService.updateEmployee(employee);
        } else {
            employeeService.createNewEmployee(employee);
        }
        response.sendRedirect("listEmployee" + "?id_department=" + employee.getIdDepartment());

    }
}
