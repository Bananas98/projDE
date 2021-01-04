package departmentmanagement.command;

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
    public Department createUpdateDepartment(@RequestBody  Department department) throws ValidException {
        return departmentService.createOrUpdateDepartment(department);
    }

    @GetMapping
    @ResponseBody
    public Department showDepartmentEditForm(@RequestBody Integer id) {
        return departmentService.getByIdDepartment(id);
    }

    @DeleteMapping
    public void deleteDepartment(@RequestBody Integer id) {
        departmentService.deleteDepartment(id);
    }


}
