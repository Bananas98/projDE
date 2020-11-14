package departmentmanagement.command.departmentCommand;


import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.service.DepartmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUpdateDepartment implements Command {
    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("id") == null){
            String name = request.getParameter("name");
            departmentDAO.create(name);
        }else {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            departmentDAO.update(id, name);
        }
        response.sendRedirect("listDepartment");

    }
}
