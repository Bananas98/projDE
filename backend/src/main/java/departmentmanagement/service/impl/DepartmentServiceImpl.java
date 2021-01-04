package departmentmanagement.service.impl;

import departmentmanagement.dao.hibernate.HibernateDepartmentImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.validate.OvalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class DepartmentServiceImpl implements DepartmentService {

    private final OvalValidator ovalValidator;

    private final HibernateDepartmentImpl departmentDAO;

    @Autowired
    public DepartmentServiceImpl(OvalValidator ovalValidator, HibernateDepartmentImpl departmentDAO) {
        this.ovalValidator = ovalValidator;
        this.departmentDAO = departmentDAO;
    }

    public Department getByIdDepartment(Integer id) {
        if (id == null) return null;
        return departmentDAO.getById(id);
    }

    public Department getByNameDepartment(String name) {
        if (name == null) return null;
        return departmentDAO.findByName(name);
    }

    public Department createOrUpdateDepartment(Department department) throws ValidException {
        ovalValidator.validate(department);
        return departmentDAO.createOrUpdate(department);
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
