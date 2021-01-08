package departmentmanagement.controllers;


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
    @ResponseBody
    public List<Employee> showDepartmentsEmployees(@RequestParam Integer id) {
        return employeeService.getAllEmployeesDepartment(id);
    }

    @PostMapping
    @ResponseBody
    public Employee createUpdateEmployee(@RequestBody Employee employee) throws ValidException {
        return employeeService.createOrUpdate(employee);
    }

    //update mapping

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }


}
