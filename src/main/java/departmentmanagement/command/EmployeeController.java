package departmentmanagement.command;


import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.util.JsonFormatter;
import departmentmanagement.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/listEmployee")
    public @ResponseBody
    JsonResponse showDepartmentsEmployees(@RequestBody Integer id) {
        JsonResponse response = new JsonResponse();
        response.setDepId(id);
        employeeService.getAllEmployeesDepartment(id);
        return response;
    }

    @PostMapping(value = "/addEditEmployee")
    public @ResponseBody
    JsonResponse createUpdateEmployee(@RequestBody Employee employee) {
        JsonResponse result = new JsonResponse();
        try {
            employeeService.createOrUpdate(employee);
            result.setStatus("SUCCESS");
        } catch (ValidException e) {
            Map<String, String> map = e.getMapError();
            result.getError().putAll(map);
            result.setResult(employee);
            result.setStatus("FAIL");
        }
        return result;
    }


    @PostMapping(value = "/deleteEmployee")
    public ResponseEntity<Employee> deleteEmployee(@RequestParam Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/checkEmail")
    public @ResponseBody
    Boolean isConsistName(@RequestBody String email) {
        String convertEmail = JsonFormatter.getJsonValue(email);
        return employeeService.getByEmailEmployee(convertEmail).getId() == null;
    }

}
