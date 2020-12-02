package departmentApp.service;

import departmentApp.dao.hibernate.HibernateDepartmentImpl;
import departmentApp.exception.ValidException;
import departmentApp.model.Department;
import departmentApp.validate.OvalValidator;

import java.util.List;

public class DepartmentService {

    private final OvalValidator ovalValidator = new OvalValidator();
    private final HibernateDepartmentImpl departmentDAO = new HibernateDepartmentImpl();


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
