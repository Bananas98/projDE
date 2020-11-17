package departmentmanagement.command.departmentCommand;


import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteDepartment implements Command {

    private DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Utils.parseInteger(request.getParameter("id"));
        try {
            departmentService.deleteDepartment(id);
        } catch (SQLException e){
            response.sendRedirect("/error");
        }
        response.sendRedirect("listDepartment");
    }
}
