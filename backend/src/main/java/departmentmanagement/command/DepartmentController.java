package departmentmanagement.command;

import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/departments")
    @ResponseBody
    public List<Department> showDepartments() {
        return departmentService.getAllDepartment();
    }

    @PostMapping("/departments")
    public void createUpdateDepartment(@RequestBody  Department department) {
        departmentService.createOrUpdateDepartment(department);
    }

    @GetMapping("/departments/{id}")
    @ResponseBody
    public Department showDepartmentEditForm(@RequestBody @PathVariable Integer id) {
        return departmentService.getByIdDepartment(id);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Department> deleteDepartment(@RequestBody @PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = "/checkName")
//    public @ResponseBody
//    Boolean isConsistName(@RequestBody String name) {
//        String convertName = JsonFormatter.getJsonValue(name);
//        return departmentService.getByNameDepartment(convertName).getId() == null;
//    }

}
