package departmentmanagement.command.employee;

import departmentmanagement.command.Command;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FormCreateUpdateEmployee implements Command {

    private final EmployeeService employeeService = new EmployeeService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        Integer idDepartment = Utils.parseInteger(request.getParameter("id_department"));
        Integer id = Utils.parseInteger(request.getParameter("id_employee"));//id
        Employee employee = employeeService.getByIdEmployee(id);
        request.setAttribute("employee",employee);
        request.setAttribute("id_department", idDepartment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employee/form.jsp");
        dispatcher.forward(request, response);

    }

}
