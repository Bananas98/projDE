package departmentApp.command.department;


import departmentApp.command.Command;
import departmentApp.exception.ValidException;
import departmentApp.model.Department;
import departmentApp.service.DepartmentService;
import departmentApp.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Map;

public class CreateUpdateDepartment implements Command {
    private final DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Department department = new Department();
        department.setName(request.getParameter("name"));
        department.setId(Utils.parseInteger(request.getParameter("id")));
        try {
            departmentService.createOrUpdateDepartment(department);
            response.sendRedirect("listDepartment");
        } catch (ValidException e) {
            Map<String, String> map = e.getMapError();
            request.setAttribute("error", map);
            request.setAttribute("department", department);
            request.getRequestDispatcher("/WEB-INF/department/form.jsp").forward(request, response);
        }

    }
}
