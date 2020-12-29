package departmentmanagement.command;


import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employees/{idDepartment}")
    public List<Employee> showDepartmentsEmployees(@RequestBody @PathVariable Integer idDepartment) {
        return employeeService.getAllEmployeesDepartment(idDepartment);
    }

    @PostMapping(value = "/employees")
    public void createUpdateEmployee(@RequestBody Employee employee) {
        employeeService.createOrUpdate(employee);
    }


    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@RequestParam @PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = "/checkEmail")
//    public @ResponseBody
//    Boolean isConsistName(@RequestBody String email) {
//        String convertEmail = JsonFormatter.getJsonValue(email);
//        return employeeService.getByEmailEmployee(convertEmail).getId() == null;
//    }

}
