package departmentmanagement.command.department;


import departmentmanagement.command.Command;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component(value = "/deleteDepartment")
public class DeleteDepartment implements Command {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Utils.parseInteger(request.getParameter("id"));
        departmentService.deleteDepartment(id);
        response.sendRedirect("listDepartment");
    }
}
