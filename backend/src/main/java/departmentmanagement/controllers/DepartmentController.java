package departmentmanagement.controllers;

import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping
    public List<Department> showDepartments() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Integer id) {
        return departmentService.getByIdDepartment(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody  Department department) throws ValidException {
        return departmentService.createOrUpdateDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }


}
