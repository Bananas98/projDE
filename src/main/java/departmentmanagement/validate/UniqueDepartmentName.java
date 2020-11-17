package departmentmanagement.validate;

import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.model.Department;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.CheckWithCheck;

import java.sql.SQLException;

public class UniqueDepartmentName implements CheckWithCheck.SimpleCheck {
    DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();

    @Override
    public boolean isSatisfied(Object o, Object o1) {
        if (o == null) {
            return true;
        } else {
            try {
                return !departmentDAO.isUnique((Department) o);
            } catch (SQLException e) {
                return false;
            }
        }
    }
}
