package departmentmanagement.command.department;


import departmentmanagement.command.Command;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Map;

@Component
public class CreateUpdateDepartment implements Command {

    @Autowired
    private DepartmentService departmentService;

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
