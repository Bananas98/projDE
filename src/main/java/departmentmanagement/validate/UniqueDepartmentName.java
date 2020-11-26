package departmentmanagement.validate;

import departmentmanagement.dao.hibernate.HibernateDepartmentImpl;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.model.Department;
import net.sf.oval.constraint.CheckWithCheck;

import java.sql.SQLException;

public class UniqueDepartmentName implements CheckWithCheck.SimpleCheck {

    private final HibernateDepartmentImpl departmentDAO = new HibernateDepartmentImpl();

    @Override
    public boolean isSatisfied(Object o, Object o1) {
       Department validate = (Department)o;
        Department department = departmentDAO.findByName(((Department) o).getName());

        return department == null|| department.getId().equals(validate.getId());

    }
}
