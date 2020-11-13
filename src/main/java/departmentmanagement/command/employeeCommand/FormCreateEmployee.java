package departmentmanagement.command.employeeCommand;

import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;
import departmentmanagement.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FormCreateEmployee implements Command {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_department = Integer.parseInt(request.getParameter("id_department"));
        String nameDepartment = departmentDAO.get(id_department).getName();
        List<Department> listDepartment = departmentDAO.getAllDepartments();
        request.setAttribute("listDepartment", listDepartment);
        request.setAttribute("id_department", id_department);
        request.setAttribute("name_department", nameDepartment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employee-form.jsp");
        dispatcher.forward(request, response);
    }
}
