package departmentmanagement.service.impl;

import departmentmanagement.dao.hibernate.HibernateDepartmentImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.validate.OvalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private OvalValidator ovalValidator;

    @Autowired
    private HibernateDepartmentImpl departmentDAO;


    public Department getByIdDepartment(Integer id) {
        if (id == null) return null;
        return departmentDAO.getById(id);
    }

    public Department getByNameDepartment(String name) {
        if (name == null) return null;
        return departmentDAO.findByName(name);
    }

    public void createOrUpdateDepartment(Department department) throws ValidException {
        ovalValidator.validate(department);
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
