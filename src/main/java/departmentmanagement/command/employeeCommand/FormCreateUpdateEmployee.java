package departmentmanagement.command.employeeCommand;

import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;
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
import java.util.List;

public class FormCreateUpdateEmployee implements Command {

    private DepartmentService departmentService = new DepartmentService();
    private EmployeeService employeeService = new EmployeeService();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("id_employee") != null){
            Integer id = Utils.parseInteger(request.getParameter("id_employee"));
            Employee existingEmployee = employeeService.getByIdEmployee(id);
            List<Department> listDepartment = departmentService.getAllDepartment();
            request.setAttribute("listDepartment", listDepartment);
            request.setAttribute("employee", existingEmployee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employee-form.jsp");
            dispatcher.forward(request, response);
        }
        else {
            Integer idDepartment = Utils.parseInteger(request.getParameter("id_department"));
            String nameDepartment = departmentService.getByIdDepartment(idDepartment).getName();
            List<Department> listDepartment = departmentService.getAllDepartment();
            request.setAttribute("listDepartment", listDepartment);
            request.setAttribute("id_department", idDepartment);
            request.setAttribute("name_department", nameDepartment);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employee-form.jsp");
            dispatcher.forward(request, response);
        }

    }
}
