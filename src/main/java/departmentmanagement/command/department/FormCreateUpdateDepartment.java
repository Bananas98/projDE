package departmentmanagement.command.department;

import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FormCreateUpdateDepartment implements Command {

    DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/department/form.jsp");
            dispatcher.forward(request, response);

        } else {
            Integer id = Utils.parseInteger(request.getParameter("id"));
            Department existingDepartment = null;
            try {
                existingDepartment = departmentService.getByIdDepartment(id);
            } catch (SQLException e){
                response.sendRedirect("/error");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/department/form.jsp");
            request.setAttribute("department", existingDepartment);
            dispatcher.forward(request, response);
        }
    }

}
