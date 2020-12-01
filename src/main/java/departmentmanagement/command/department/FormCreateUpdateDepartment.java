package departmentmanagement.command.department;

import departmentmanagement.command.Command;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(value = "/createUpdateFormDepartment")
public class FormCreateUpdateDepartment implements Command {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/department/form.jsp");
        Integer id = Utils.parseInteger(request.getParameter("id"));
        Department department = departmentService.getByIdDepartment(id);
        request.setAttribute("department", department);
        dispatcher.forward(request, response);
    }

}
