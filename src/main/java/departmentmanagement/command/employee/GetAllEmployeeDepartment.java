package departmentmanagement.command.employee;


import departmentmanagement.command.Command;
import departmentmanagement.model.Employee;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetAllEmployeeDepartment implements Command {

    private final DepartmentService departmentService = new DepartmentService();
    private final EmployeeService employeeService = new EmployeeService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Integer idDepartment = Utils.parseInteger(request.getParameter("id_department"));

        String nameDepartment = departmentService.getByIdDepartment(idDepartment).getName();
        List<Employee> listEmployee = employeeService.getAllEmployeesDepartment(idDepartment);
        request.setAttribute("listEmployee", listEmployee);
        request.setAttribute("id_department", idDepartment);
        request.setAttribute("name_department", nameDepartment);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employee/list.jsp");
        dispatcher.forward(request, response);
    }
}
