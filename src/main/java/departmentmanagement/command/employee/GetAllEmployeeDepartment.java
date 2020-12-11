package departmentmanagement.command.employee;


import departmentmanagement.command.Command;
import departmentmanagement.model.Employee;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component(value = "/listEmployee")
public class GetAllEmployeeDepartment implements Command {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @Autowired
    public GetAllEmployeeDepartment(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer idDepartment = Utils.parseInteger(request.getParameter("id_department"));
        if (idDepartment == null){
            response.sendRedirect("/");
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