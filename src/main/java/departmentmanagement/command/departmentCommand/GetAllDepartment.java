package departmentmanagement.command.departmentCommand;



import departmentmanagement.command.Command;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllDepartment implements Command {

    private DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> listDepartment = departmentService.getAllDepartment();
        request.setAttribute("listDepartment", listDepartment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/department-list.jsp");
        dispatcher.forward(request, response);
    }
}
