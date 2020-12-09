package departmentmanagement.command;

import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/showEmployees")
    public ModelAndView showDepartmentsEmployees(@RequestParam(required = true) Integer id) {
        ModelAndView modelAndView = new ModelAndView("employee/list", "employee", employeeService.getAllEmployeesDepartment(id));
        modelAndView.addObject("id_department", id);
        return modelAndView;
    }

    @PostMapping(value = "/addUpdateEmployee")
    public ModelAndView createUpdateEmployee(Employee employee) {
        ModelAndView mv = new ModelAndView("employee/list");
        Integer depId = employee.getId();
        try {
            employeeService.createOrUpdate(employee);
            mv.addObject("employee", employeeService.getAllEmployeesDepartment(depId));
        } catch (ValidException e) {
            Map<String, String> map = e.getMapError();
            mv.clear();
            mv.addObject("error", map);
            mv.setViewName("department/form");
            mv.addObject("employee", employee);
        }
        return mv;
    }

    @GetMapping(value = "/createFormEmployee")
    public ModelAndView formCreateDepartment() {
        return new ModelAndView("employee/form", "employee", new Employee());
    }

    @GetMapping(value = "/updateFormEmployee")
    public ModelAndView formUpdateDepartment(@RequestParam(required = true) Integer id) {
        return new ModelAndView("employee/form", "employee", employeeService.getByIdEmployee(id));
    }

    @GetMapping(value = "/deleteEmployee")
    public String deleteEmployee(@RequestParam(required = true) Integer id, Integer depId) {
        employeeService.deleteEmployee(id);
        return "redirect:/showEmployees?id=" + depId;
    }
}
