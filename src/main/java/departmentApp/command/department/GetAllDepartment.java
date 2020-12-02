package departmentApp.command.department;


import departmentApp.command.Command;
import departmentApp.service.DepartmentService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GetAllDepartment implements Command {

    private final DepartmentService departmentService = new DepartmentService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listDepartment", departmentService.getAllDepartment());
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/department/list.jsp");
        dispatcher.forward(request, response);
    }
}
