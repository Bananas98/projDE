package departmentmanagement.validate;

import departmentmanagement.dao.hibernate.HibernateEmployeeImpl;
import departmentmanagement.model.Employee;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UniqueEmployeeEmail implements CheckWithCheck.SimpleCheck{

    @Autowired
    private HibernateEmployeeImpl employeeDAO;

    @Override
    public boolean isSatisfied(Object o, Object o1) {
        Employee validate = (Employee)o;
        Employee employee = employeeDAO.findByEmail(((Employee) o).getMail());
        return employee == null|| employee.getId().equals(validate.getId());
    }
}
