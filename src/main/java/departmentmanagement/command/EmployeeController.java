package departmentmanagement.command;


import departmentmanagement.model.Department;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/listEmployees")
    public List<Employee> showDepartmentsEmployees(@RequestParam Integer id) {
        return employeeService.getAllEmployeesDepartment(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createUpdateEmployee")
    public @ResponseBody JsonResponse createUpdateEmployee(@RequestBody Employee employee, @RequestBody Integer id_department) {
        JsonResponse result = new JsonResponse();

            employeeService.getAllEmployeesDepartment(id_department);
            result.setStatus("SUCCESS");


//        catch (ValidException e) {
//            Map<String, String> map = e.getMapError();
//            result.getError().putAll(map);
//            result.setResult(employee);
//            result.setStatus("FAIL");
//        }
        return result;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/createUpdateFormEmployee")
    public Employee formCreateUpdateEmployee(@RequestParam Integer id) {
        return id != null ? employeeService.getByIdEmployee(id) : new Employee();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteEmployee")
    public String deleteEmployee(@RequestParam Integer id, Integer depId) {
        employeeService.deleteEmployee(id);
        return "redirect:/listEmployees" + depId;
    }
}
