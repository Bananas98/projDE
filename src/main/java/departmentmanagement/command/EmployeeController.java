package departmentmanagement.command;


import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/listEmployee")
    public @ResponseBody JsonResponse showDepartmentsEmployees(@RequestParam Integer id) {
        JsonResponse response = new JsonResponse();
        response.setDepId(id);
        employeeService.getAllEmployeesDepartment(id);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addEditEmployee")
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


    @RequestMapping(method = RequestMethod.POST, value = "/deleteEmployee")
    public ResponseEntity<Employee> deleteEmployee(@RequestParam Integer id, Integer depId) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
