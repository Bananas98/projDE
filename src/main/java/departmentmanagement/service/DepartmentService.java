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


    public Department getByIdDepartment(Integer id) {
        if (id==null) return null;
        try {
            return departmentDAO.getById(id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void createOrUpdateDepartment(Department department) throws ValidException{
        ovalValidator.setValidator(department);
        try {
            departmentDAO.createOrUpdate(department);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void deleteDepartment(Integer idDepartment) {
        if (idDepartment!=null) {
            try {
                departmentDAO.delete(idDepartment);
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }

    }

    public List<Department> getAllDepartment() {
        try {
            return departmentDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


}
