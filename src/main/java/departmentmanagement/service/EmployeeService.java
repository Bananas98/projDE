package departmentmanagement.service;


import departmentmanagement.dao.hibernate.HibernateEmployeeImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.validate.OvalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {


    @Autowired
    private OvalValidator ovalValidator;

    @Autowired
    private HibernateEmployeeImpl employeeDAO;

    public void createOrUpdate(Employee employee) throws ValidException {

        if (!employee.getDepartment().getId().toString().isEmpty()) {
            ovalValidator.setValidator(employee);
            employeeDAO.createOrUpdate(employee);
        }
    }

    public void deleteEmployee(Integer employeeId) {

        if (employeeId != null) {
            employeeDAO.delete(employeeId);
        }

    }


    public Employee getByIdEmployee(Integer id) {
        if (id == null) return null;
        return employeeDAO.getById(id);
    }


    public List<Employee> getAllEmployeesDepartment(Integer idDepartment) {

        return employeeDAO.getAll(idDepartment);

    }

}
