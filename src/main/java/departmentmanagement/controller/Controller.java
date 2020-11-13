package departmentmanagement.controller;



import departmentmanagement.command.Command;
import departmentmanagement.command.departmentCommand.CreateDepartment;
import departmentmanagement.command.employeeCommand.CreateEmployee;
import departmentmanagement.command.departmentCommand.DeleteDepartment;
import departmentmanagement.command.employeeCommand.DeleteEmployee;
import departmentmanagement.command.departmentCommand.FormCreateDepartment;
import departmentmanagement.command.employeeCommand.FormCreateEmployee;
import departmentmanagement.command.departmentCommand.FormEditDepartment;
import departmentmanagement.command.employeeCommand.FormEditEmployee;
import departmentmanagement.command.departmentCommand.GetAllDepartment;
import departmentmanagement.command.employeeCommand.GetAllEmployeeDepartment;
import departmentmanagement.command.departmentCommand.UpdateDepartment;
import departmentmanagement.command.employeeCommand.UpdateEmployee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class Controller extends HttpServlet {

    private Map<String, Command> commandMap;


    @Override
    public void init() throws ServletException {
        commandMap = new HashMap<>();

        commandMap.put("listDepartment", new GetAllDepartment());
        commandMap.put("listEmployee", new GetAllEmployeeDepartment());
        commandMap.put("newDepartment", new FormCreateDepartment());
        commandMap.put("newEmployee", new FormCreateEmployee());
        commandMap.put("editDepartment", new FormEditDepartment());
        commandMap.put("editEmployee", new FormEditEmployee());
        commandMap.put("insertDepartment", new CreateDepartment());
        commandMap.put("insertEmployee", new CreateEmployee());
        commandMap.put("deleteDepartment", new DeleteDepartment());
        commandMap.put("deleteEmployee", new DeleteEmployee());
        commandMap.put("updateDepartment", new UpdateDepartment());
        commandMap.put("updateEmployee", new UpdateEmployee());
        super.init();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI().replaceAll("/", "");
        System.out.println(url);
        Command command = commandMap.getOrDefault(url, commandMap.get("listDepartment"));
        if (command != null){
            command.execute(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
