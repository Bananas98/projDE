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
    @ResponseBody
    public List<Department> showDepartments() {
        return departmentService.getAllDepartment();
    }

    @PostMapping
    @ResponseBody
    public Department createDepartment(@RequestBody  Department department) throws ValidException {
        return departmentService.createOrUpdateDepartment(department);
    }

    @PostMapping("/{id}")
    @ResponseBody
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Department department) throws ValidException {
        department.setId(id);
        return departmentService.createOrUpdateDepartment(department);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Department getDepartment(@PathVariable Integer id) {
        return departmentService.getByIdDepartment(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }


}
