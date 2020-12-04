package departmentmanagement.validate;

import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.service.impl.DepartmentServiceImpl;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UniqueDepartmentName implements CheckWithCheck.SimpleCheck {

    private final DepartmentService service;

    @Autowired
    public UniqueDepartmentName(DepartmentService service) {
        this.service = service;
    }

    @Override
    public boolean isSatisfied(Object o, Object o1) {
       Department validate = (Department)o;
        Department department = service.getByNameDepartment(((Department) o).getName());
        return department == null|| department.getId().equals(validate.getId());
    }
}
