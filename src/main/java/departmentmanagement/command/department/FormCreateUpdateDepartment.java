package departmentmanagement.command.department;

import departmentmanagement.command.Command;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FormCreateUpdateDepartment implements Command {

    private final DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/department/form.jsp");
        Integer id = Utils.parseInteger(request.getParameter("id"));
        if (id!=null) {
            Department department = departmentService.getByIdDepartment(id);
            request.setAttribute("department", department);
        }
        dispatcher.forward(request, response);
    }

}
