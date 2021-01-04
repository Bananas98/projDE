package departmentmanagement.command;


import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> showDepartmentsEmployees(@RequestBody Integer idDepartment) {
        return employeeService.getAllEmployeesDepartment(idDepartment);
    }

    @PostMapping
    public Employee createUpdateEmployee(@RequestBody Employee employee) throws ValidException {
        return employeeService.createOrUpdate(employee);
    }


    @DeleteMapping
    public void deleteEmployee(@RequestParam Integer id) {
        employeeService.deleteEmployee(id);
    }


}
