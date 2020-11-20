package departmentmanagement.validate;

import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.model.Employee;
import net.sf.oval.constraint.CheckWithCheck;

import java.sql.SQLException;

public class UniqueEmployeeEmail implements CheckWithCheck.SimpleCheck{

    private final EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    @Override
    public boolean isSatisfied(Object o, Object o1) {
        Employee validate = (Employee)o;
        Employee employee = null;
        try {
            employee = employeeDAO.findByEmail(((Employee) o).getMail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee == null|| employee.getId().equals(validate.getId());

    }
}
