package departmentmanagement.service;

import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.validate.OvalValidator;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {

    private final OvalValidator ovalValidator = new OvalValidator();
    private final DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();


    public Department getByIdDepartment(Integer id) throws SQLException {
        if (id==null) return null;
        return departmentDAO.getById(id);
    }

    public void createOrUpdateDepartment(Department department) throws ValidException, SQLException {
        ovalValidator.setValidator(department);
        departmentDAO.createOrUpdate(department);
    }

    public void deleteDepartment(Integer idDepartment) throws SQLException {
        departmentDAO.delete(idDepartment);
    }

    public List<Department> getAllDepartment() throws SQLException {
        return departmentDAO.getAll();
    }


}
