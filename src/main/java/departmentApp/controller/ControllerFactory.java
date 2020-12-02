package departmentApp.controller;

import departmentApp.command.Command;
import departmentApp.command.CommandError;
import departmentApp.command.department.CreateUpdateDepartment;
import departmentApp.command.department.DeleteDepartment;
import departmentApp.command.department.FormCreateUpdateDepartment;
import departmentApp.command.department.GetAllDepartment;
import departmentApp.command.employee.CreateUpdateEmployee;
import departmentApp.command.employee.DeleteEmployee;
import departmentApp.command.employee.FormCreateUpdateEmployee;
import departmentApp.command.employee.GetAllEmployeeDepartment;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private final Map<String, Command> commandMap;
    private final Command getAllDepartment = new GetAllDepartment();

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

    public Command getCommand(HttpServletRequest request) {
        return commandMap.getOrDefault(request.getRequestURI(), getAllDepartment);
    }
}
