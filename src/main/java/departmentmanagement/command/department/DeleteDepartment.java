package departmentmanagement.command.department;


import departmentmanagement.command.Command;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteDepartment implements Command {

    private final DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Integer id = Utils.parseInteger(request.getParameter("id"));
        departmentService.deleteDepartment(id);
        response.sendRedirect("listDepartment");
    }
}
