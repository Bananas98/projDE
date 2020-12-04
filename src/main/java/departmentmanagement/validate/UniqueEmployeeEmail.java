package departmentmanagement.validate;

import departmentmanagement.dao.hibernate.HibernateEmployeeImpl;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.service.impl.EmployeeServiceImpl;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UniqueEmployeeEmail implements CheckWithCheck.SimpleCheck{

    @Autowired
    private HibernateEmployeeImpl employeeDao;


    @Override
    public boolean isSatisfied(Object o, Object o1) {
        Employee validate = (Employee)o;
        Employee employee = employeeDao.findByEmail(((Employee) o).getMail());
        return employee == null|| employee.getId().equals(validate.getId());
    }
}
