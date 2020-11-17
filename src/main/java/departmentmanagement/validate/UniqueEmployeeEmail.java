package departmentmanagement.validate;

import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Employee;
import net.sf.oval.constraint.CheckWithCheck;

import java.sql.SQLException;

public class UniqueEmployeeEmail implements CheckWithCheck.SimpleCheck{

    Dao<Employee> employeeDAO = new EmployeeDAOImpl();

    @Override
    public boolean isSatisfied(Object o, Object o1) {
        if(o == null) {
            return true;
        } else {
            try {
                return !employeeDAO.isUnique((Employee) o);
            } catch (SQLException e) {
                return false;
            }
        }
    }
}
