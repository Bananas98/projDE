package departmentmanagement.command.employee;

import departmentmanagement.command.Command;
import departmentmanagement.model.Department;
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

public class FormCreateUpdateEmployee implements Command {

    private final DepartmentService departmentService = new DepartmentService();
    private final EmployeeService employeeService = new EmployeeService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        List<Department> listDepartment = departmentService.getAllDepartment();

        if (!Utils.isNullOrEmpty(request.getParameter("id_employee"))) {
            Integer id = Utils.parseInteger(request.getParameter("id_employee"));
            Employee existingEmployee = employeeService.getByIdEmployee(id);
            request.setAttribute("employee", existingEmployee);
        } else {
            Integer idDepartment = Utils.parseInteger(request.getParameter("id_department"));
            String nameDepartment = departmentService.getByIdDepartment(idDepartment).getName();
            request.setAttribute("id_department", idDepartment);
            request.setAttribute("name_department", nameDepartment);
        }
        request.setAttribute("listDepartment", listDepartment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employee/form.jsp");
        dispatcher.forward(request, response);
    }

}
