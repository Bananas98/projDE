package departmentmanagement.command.formUpdate;

import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormEditDepartment implements Command {

    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Department existingDepartment = departmentDAO.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("department-form.jsp");
        request.setAttribute("department", existingDepartment);
        dispatcher.forward(request, response);
    }
}
