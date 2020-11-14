package departmentmanagement.command.employeeCommand;



import departmentmanagement.command.Command;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;
import departmentmanagement.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CreateUpdateEmployee implements Command {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("id") == null){
            String name = request.getParameter("name");
            Date dateOfBirthday = Date.valueOf(request.getParameter("dateOfBirthday"));
            String mail = request.getParameter("mail");
            int salary = Integer.parseInt(request.getParameter("salary"));
            int idDepartment = Integer.parseInt(request.getParameter("id_department"));
            employeeDAO.create(name, dateOfBirthday, mail, salary, idDepartment);
            response.sendRedirect("listEmployee" + "?id_department=" + idDepartment);
        }
        else {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Date dateOfBirthday = Date.valueOf(request.getParameter("dateOfBirthday"));
            String mail = request.getParameter("mail");
            int salary = Integer.parseInt(request.getParameter("salary"));
            int idDepartment = Integer.parseInt(request.getParameter("id_department"));
            employeeDAO.update(id, name, dateOfBirthday, mail, salary, idDepartment);
            response.sendRedirect("listEmployee" + "?id_department=" + idDepartment);
        }
    }


}
