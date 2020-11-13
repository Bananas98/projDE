package departmentmanagement.command.departmentCommand;


import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.service.DepartmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDepartment implements Command {

    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        departmentDAO.delete(id);
        response.sendRedirect("listDepartment");
    }
}
