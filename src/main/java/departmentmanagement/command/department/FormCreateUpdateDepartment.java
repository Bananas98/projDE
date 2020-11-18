package departmentmanagement.command.department;

import com.mysql.jdbc.StringUtils;
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
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/department/form.jsp");

        if (!Utils.isNullOrEmpty(request.getParameter("id"))) {
            Integer id = Utils.parseInteger(request.getParameter("id"));
            Department department = departmentService.getByIdDepartment(id);
            request.setAttribute("department", department);
        }
        dispatcher.forward(request, response);
    }

}
