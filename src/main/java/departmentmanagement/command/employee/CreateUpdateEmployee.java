package departmentmanagement.command.employee;


import departmentmanagement.command.Command;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

public class CreateUpdateEmployee implements Command {

    private EmployeeService employeeService = new EmployeeService();
    private DepartmentService departmentService = new DepartmentService();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setDateOfBirthday(Date.valueOf(request.getParameter("dateOfBirthday")));
        employee.setMail(request.getParameter("mail"));
        employee.setSalary(Utils.parseInteger(request.getParameter("salary")));
        employee.setIdDepartment(Utils.parseInteger(request.getParameter("id_department")));

        try {
            employee.setId(Utils.parseInteger(request.getParameter("id_employee")));
            employeeService.createOrUpdate(employee);
            response.sendRedirect("listEmployee" + "?id_department=" + employee.getIdDepartment());
        } catch (ValidException e) {
            Map<String,String> map =  e.getMapError();
            request.setAttribute("employee",employee);
            request.setAttribute("error", map);
            request.setAttribute("listDepartment",departmentService.getAllDepartment());
            request.getRequestDispatcher("WEB-INF/employee/form.jsp").forward(request,response);
        }

    }
}
