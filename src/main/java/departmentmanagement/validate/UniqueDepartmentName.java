package departmentmanagement.validate;

import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.model.Department;
import net.sf.oval.constraint.CheckWithCheck;

import java.sql.SQLException;

public class UniqueDepartmentName implements CheckWithCheck.SimpleCheck {

    private final DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();

    @Override
    public boolean isSatisfied(Object o, Object o1) {
       Department validate = (Department)o;
        Department department = null;
        try {
            department = departmentDAO.findByName(((Department) o).getName());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return department == null|| department.getId().equals(validate.getId());

    }
}
