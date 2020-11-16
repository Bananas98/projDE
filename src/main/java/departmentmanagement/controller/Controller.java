package departmentmanagement.controller;


import departmentmanagement.command.Command;
import departmentmanagement.command.CommandError;
import departmentmanagement.command.departmentCommand.*;
import departmentmanagement.command.employeeCommand.*;

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

    private final Map<String, Command> commandMap;

    {
        commandMap = new HashMap<>();

        commandMap.put("/listDepartment", new GetAllDepartment());
        commandMap.put("/listEmployee", new GetAllEmployeeDepartment());
        commandMap.put("/createUpdateFormDepartment", new FormCreateUpdateDepartment());
        commandMap.put("/createUpdateFormEmployee", new FormCreateUpdateEmployee());
        commandMap.put("/insertUpdateDepartment", new CreateUpdateDepartment());
        commandMap.put("/insertUpdateEmployee", new CreateUpdateEmployee());
        commandMap.put("/deleteDepartment", new DeleteDepartment());
        commandMap.put("/deleteEmployee", new DeleteEmployee());
        commandMap.put("/error", new CommandError());

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String url = request.getRequestURI();
            Command command = commandMap.getOrDefault(url, commandMap.get("/listDepartment"));
            if (command != null) {
                command.execute(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            response.sendRedirect("error");
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
