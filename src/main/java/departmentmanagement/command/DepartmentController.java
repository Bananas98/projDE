package departmentmanagement.command;

import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/")
    public ModelAndView showDepartments() {
        return new ModelAndView("department/list", "department",
                departmentService.getAllDepartment());
    }

    @PostMapping(value = "/addUpdateDepartment")
    public ModelAndView createUpdateDepartment(Department department) {
        ModelAndView mv = new ModelAndView("department/list");
        try {
            departmentService.createOrUpdateDepartment(department);
            mv.addObject("department", departmentService.getAllDepartment());
        } catch (ValidException e) {
            Map<String, String> map = e.getMapError();
            mv.clear();
            mv.addObject("error", map);
            mv.setViewName("department/form");
            mv.addObject("department", department);
        }
        return mv;

    }

    @GetMapping(value = "/createFormDepartment")
    public ModelAndView formCreateDepartment() {
        return new ModelAndView("department/form", "department", new Department());
    }

    @GetMapping(value = "/updateFormDepartment")
    public ModelAndView formUpdateDepartment(@RequestParam(required = true) Integer id) {
        return new ModelAndView("department/form", "department", departmentService.getByIdDepartment(id));
    }

    @GetMapping(value = "/deleteDepartment")
    public String deleteDepartment(@RequestParam(required = true) Integer id) {
        departmentService.deleteDepartment(id);
        return "redirect:/";
    }

}
