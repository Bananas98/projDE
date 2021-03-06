package departmentApp.command.employee;


import departmentApp.command.Command;
import departmentApp.exception.ValidException;
import departmentApp.model.Department;
import departmentApp.model.Employee;
import departmentApp.service.DepartmentService;
import departmentApp.service.EmployeeService;
import departmentApp.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Map;

public class CreateUpdateEmployee implements Command {

    private final EmployeeService employeeService = new EmployeeService();
    private final DepartmentService departmentService = new DepartmentService();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Employee employee = new Employee();
        Department department = new Department();
        employee.setName(request.getParameter("name"));
        employee.setDateOfBirthday(Utils.parseDate(request.getParameter("dateOfBirthday")));
        employee.setMail(request.getParameter("mail"));
        employee.setSalary(Utils.parseInteger(request.getParameter("salary")));
        department.setId(Utils.parseInteger(request.getParameter("id_department")));
        employee.setDepartment(department);
        employee.setId(Utils.parseInteger(request.getParameter("id")));
        try {
            employeeService.createOrUpdate(employee);
            response.sendRedirect("listEmployee" + "?id_department=" + employee.getDepartment().getId());
        } catch (ValidException e) {
            Map<String,String> map =  e.getMapError();
            request.setAttribute("employee",employee);
            request.setAttribute("id_department",Utils.parseInteger(request.getParameter("id_department")));
            request.setAttribute("error", map);
            request.setAttribute("listDepartment",departmentService.getAllDepartment());
            request.getRequestDispatcher("WEB-INF/employee/form.jsp").forward(request,response);
        }

    }
}
