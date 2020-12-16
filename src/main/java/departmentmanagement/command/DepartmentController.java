package departmentmanagement.command;

import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/")
    public ModelAndView showDepartments() {
        return new ModelAndView("department/list", "department", departmentService.getAllDepartment());
    }

    @PostMapping(value = "/createUpdateDepartment")
    public ModelAndView createUpdateDepartment(Department department) {
        ModelAndView mv = new ModelAndView("department/list");
        try {
            departmentService.createOrUpdateDepartment(department);
            mv.addObject("department", departmentService.getAllDepartment());
        } catch (ValidException e) {
            mv.addObject("error", e.getMapError());
            mv.setViewName("department/form");
            mv.addObject("department", department);
        }
        return mv;

    }

    @GetMapping(value = "/createUpdateFormDepartment")
    public ModelAndView formCreateUpdateDepartment(@RequestParam Integer id) {
        ModelAndView mv = new ModelAndView("employee/form");
        mv.addObject("department",id != null ? departmentService.getByIdDepartment(id) : new Department());
        return mv;
    }

    @GetMapping(value = "/deleteDepartment")
    public String deleteDepartment(@RequestParam Integer id) {
        departmentService.deleteDepartment(id);
        return "redirect:/";
    }

}
