package departmentApp.command.employee;


import departmentApp.command.Command;
import departmentApp.model.Employee;
import departmentApp.service.DepartmentService;
import departmentApp.service.EmployeeService;
import departmentApp.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllEmployeeDepartment implements Command {

    private DepartmentService departmentService = new DepartmentService();
    private EmployeeService employeeService = new EmployeeService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer idDepartment = Utils.parseInteger(request.getParameter("id_department"));
        if (idDepartment == null){
            response.sendRedirect("/listDepartment");
        }
        else {
            String nameDepartment = departmentService.getByIdDepartment(idDepartment).getName();
            List<Employee> listEmployee = employeeService.getAllEmployeesDepartment(idDepartment);
            request.setAttribute("listEmployee", listEmployee);
            request.setAttribute("id_department", idDepartment);
            request.setAttribute("name_department", nameDepartment);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employee/list.jsp");
            dispatcher.forward(request, response);
        }
    }
}
