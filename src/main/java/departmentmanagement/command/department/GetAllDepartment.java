package departmentmanagement.command.department;


import departmentmanagement.command.Command;
import departmentmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(value = "/")
public class GetAllDepartment implements Command {

    private final DepartmentService departmentService;

    @Autowired
    public GetAllDepartment(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listDepartment", departmentService.getAllDepartment());
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/department/list.jsp");
        dispatcher.forward(request, response);
    }
}
