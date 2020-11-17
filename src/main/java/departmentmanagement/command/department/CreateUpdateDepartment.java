package departmentmanagement.command.department;


import departmentmanagement.command.Command;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class CreateUpdateDepartment implements Command {
    private DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Department department = new Department();
        department.setName(request.getParameter("name"));

        try {
            department.setId(Utils.parseInteger(request.getParameter("id")));
            departmentService.createOrUpdateDepartment(department);
            response.sendRedirect("listDepartment");
        } catch (ValidException e) {
            Map<String, String> map = e.getMapError();
            request.setAttribute("error", map);
            request.setAttribute("department", department);
            request.getRequestDispatcher("/WEB-INF/department/form.jsp").forward(request, response);
        } catch (SQLException e) {
            response.sendRedirect("/error");
        }

    }
}