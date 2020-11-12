package departmentmanagement.command.create;



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

public class CreateEmployee implements Command {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Date dateOfBirthday = Date.valueOf(reverseDate(request.getParameter("dateOfBirthday")));
        String mail = request.getParameter("mail");
        int salary = Integer.parseInt(request.getParameter("salary"));
        int idDepartment = Integer.parseInt(request.getParameter("id_department"));
        employeeDAO.create(name, dateOfBirthday, mail, salary, idDepartment);
        response.sendRedirect("listEmployee" + "?id_department=" + idDepartment);
    }

    private String reverseDate(String date) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = date.split("\\.");
        for (int i = arr.length - 1; i >= 0; i--) {
            stringBuilder.append(arr[i]).append("-");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }


}
