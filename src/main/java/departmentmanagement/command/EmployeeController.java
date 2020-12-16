package departmentmanagement.command;

import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/listEmployees")
    public ModelAndView showDepartmentsEmployees(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("employee/list", "employee", employeeService.getAllEmployeesDepartment(id));
        modelAndView.addObject("id_department", id);
        return modelAndView;
    }

    @PostMapping(value = "/createUpdateEmployee")
    public ModelAndView createUpdateEmployee(Employee employee,Integer id_department) {
        ModelAndView mv = new ModelAndView("employee/list");
        try {
            employeeService.createOrUpdate(employee);
            mv.addObject("employee", employeeService.getAllEmployeesDepartment(id_department));
        } catch (ValidException e) {
            mv.addObject("error", e.getMapError());
            mv.setViewName("employee/form");
            mv.addObject("employee", employee);
        }
        return mv;
    }


    @GetMapping(value = "/createUpdateFormEmployee")
    public ModelAndView formCreateUpdateDepartment(@RequestParam Integer id) {
        ModelAndView mv = new ModelAndView("employee/form");
        mv.addObject("employee",id != null ? employeeService.getByIdEmployee(id) : new Employee());
        return mv;
    }

    @GetMapping(value = "/deleteEmployee")
    public String deleteEmployee(@RequestParam Integer id, Integer depId) {
        employeeService.deleteEmployee(id);
        return "redirect:/listEmployees" + depId;
    }
}
