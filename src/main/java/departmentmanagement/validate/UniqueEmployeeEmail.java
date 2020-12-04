package departmentmanagement.validate;

import departmentmanagement.model.Employee;
import departmentmanagement.service.impl.EmployeeServiceImpl;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UniqueEmployeeEmail implements CheckWithCheck.SimpleCheck{

    @Autowired
    private EmployeeServiceImpl service;

    @Override
    public boolean isSatisfied(Object o, Object o1) {
        Employee validate = (Employee)o;
        Employee employee = service.getByEmailEmployee(((Employee) o).getMail());
        return employee == null|| employee.getId().equals(validate.getId());
    }
}
