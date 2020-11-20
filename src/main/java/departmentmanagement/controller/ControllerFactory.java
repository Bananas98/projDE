package departmentmanagement.controller;

import departmentmanagement.command.Command;
import departmentmanagement.command.CommandError;
import departmentmanagement.command.department.CreateUpdateDepartment;
import departmentmanagement.command.department.DeleteDepartment;
import departmentmanagement.command.department.FormCreateUpdateDepartment;
import departmentmanagement.command.department.GetAllDepartment;
import departmentmanagement.command.employee.CreateUpdateEmployee;
import departmentmanagement.command.employee.DeleteEmployee;
import departmentmanagement.command.employee.FormCreateUpdateEmployee;
import departmentmanagement.command.employee.GetAllEmployeeDepartment;

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
