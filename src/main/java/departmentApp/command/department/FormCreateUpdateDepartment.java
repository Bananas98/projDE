package departmentApp.command.department;

import departmentApp.command.Command;
import departmentApp.model.Department;
import departmentApp.service.DepartmentService;
import departmentApp.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormCreateUpdateDepartment implements Command {

    private final DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/department/form.jsp");
        Integer id = Utils.parseInteger(request.getParameter("id"));
        Department department = departmentService.getByIdDepartment(id);
        request.setAttribute("department", department);
        dispatcher.forward(request, response);
    }

}
