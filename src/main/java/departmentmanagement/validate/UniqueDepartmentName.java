package departmentmanagement.validate;

import departmentmanagement.dao.hibernate.HibernateDepartmentImpl;
import departmentmanagement.model.Department;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UniqueDepartmentName implements CheckWithCheck.SimpleCheck {

    @Autowired
    private HibernateDepartmentImpl departmentDAO;

    @Override
    public boolean isSatisfied(Object o, Object o1) {
       Department validate = (Department)o;
        Department department = departmentDAO.findByName(((Department) o).getName());
        return department == null|| department.getId().equals(validate.getId());
    }
}
