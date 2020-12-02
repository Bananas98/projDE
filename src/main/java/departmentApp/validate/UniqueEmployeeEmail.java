package departmentApp.validate;

import departmentApp.dao.hibernate.HibernateEmployeeImpl;
import departmentApp.model.Employee;
import net.sf.oval.constraint.CheckWithCheck;

public class UniqueEmployeeEmail implements CheckWithCheck.SimpleCheck{

    private final HibernateEmployeeImpl employeeDAO = new HibernateEmployeeImpl();

    @Override
    public boolean isSatisfied(Object o, Object o1) {
        Employee validate = (Employee)o;
        Employee employee = employeeDAO.findByEmail(((Employee) o).getMail());

        return employee == null|| employee.getId().equals(validate.getId());

    }
}
