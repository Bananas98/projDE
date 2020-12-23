package departmentmanagement.command;

import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.util.JsonFormatter;
import departmentmanagement.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/listDepartment")
    public @ResponseBody
    List<Department> showDepartments() {
        return departmentService.getAllDepartment();
    }

    @RequestMapping(value = "/addEditDepartment")
    public @ResponseBody
    JsonResponse createUpdateDepartment(@RequestBody Department department) {
        JsonResponse result = new JsonResponse();
        try {
            departmentService.createOrUpdateDepartment(department);
            result.setStatus("SUCCESS");
        } catch (ValidException e) {
            Map<String, String> map = e.getMapError();
            result.getError().putAll(map);
            result.setResult(department);
            result.setStatus("FAIL");
        }
        return result;
    }

    @RequestMapping(value = "/editDepartment", method = RequestMethod.POST)
    public @ResponseBody Department showDepartmentEditForm(@RequestBody Integer id) {
        return departmentService.getByIdDepartment(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteDepartment")
    public ResponseEntity <Department> deleteDepartment(@RequestBody Integer id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/checkName")
    public @ResponseBody Boolean isConsistName(@RequestBody String name) {
        String convertName = JsonFormatter.getJsonValue(name);
        return departmentService.getByNameDepartment(convertName).getId() == null;
    }

}
