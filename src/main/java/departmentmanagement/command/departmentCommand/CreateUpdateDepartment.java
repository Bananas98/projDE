package departmentmanagement.command.departmentCommand;


import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUpdateDepartment implements Command {
    private DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Department department = new Department();
        if (request.getParameter("id") == null){
            department.setName(request.getParameter("name"));
            departmentService.createNewDepartment(department);
        }else {
            department.setId(Utils.parseInteger(request.getParameter("id")));
            department.setName(request.getParameter("name"));
            departmentService.updateDepartment(department);
        }
        response.sendRedirect("listDepartment");

    }

}
