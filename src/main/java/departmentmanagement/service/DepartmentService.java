package departmentmanagement.service;

import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.validate.OvalValidator;

import java.util.List;

public class DepartmentService {

    private final OvalValidator ovalValidator = new OvalValidator();
    private final DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();


    public Department getByIdDepartment(Integer id) {
        if (id == null) return null;
        return departmentDAO.getById(id);
    }

    public void createOrUpdateDepartment(Department department) throws ValidException {
        ovalValidator.setValidator(department);
        departmentDAO.createOrUpdate(department);

    }

    public void deleteDepartment(Integer idDepartment) {
        if (idDepartment != null) {
            departmentDAO.delete(idDepartment);
        }

    }

    public List<Department> getAllDepartment() {
        return departmentDAO.getAll();
    }


}
