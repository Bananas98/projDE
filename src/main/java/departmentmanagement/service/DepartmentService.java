package departmentmanagement.service;

import departmentmanagement.dao.hibernate.HibernateDepartmentImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.validate.OvalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private OvalValidator ovalValidator;

    @Autowired
    private HibernateDepartmentImpl departmentDAO;


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
