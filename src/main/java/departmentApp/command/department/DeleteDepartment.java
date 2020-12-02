package departmentApp.command.department;


import departmentApp.command.Command;
import departmentApp.service.DepartmentService;
import departmentApp.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteDepartment implements Command {

    private final DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Utils.parseInteger(request.getParameter("id"));
        departmentService.deleteDepartment(id);
        response.sendRedirect("listDepartment");
    }
}
