package departmentmanagement.service.impl;


import departmentmanagement.dao.hibernate.HibernateEmployeeImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.validate.OvalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class EmployeeServiceImpl implements EmployeeService {

    private final OvalValidator ovalValidator;

    private final HibernateEmployeeImpl employeeDAO;

    @Autowired
    public EmployeeServiceImpl(OvalValidator ovalValidator, HibernateEmployeeImpl employeeDAO) {
        this.ovalValidator = ovalValidator;
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public Employee createOrUpdate(Employee employee) throws ValidException {
        if (employee.getDepartment().getId().toString().isEmpty()) {
           ovalValidator.validate(employee);
        }
        return employeeDAO.createOrUpdate(employee);
    }

    @Transactional
    public void deleteEmployee(Integer employeeId) {
        if (employeeId != null) {
            employeeDAO.delete(employeeId);
        }

    }


    public Employee getByIdEmployee(Integer id) {
        if (id == null) return null;
        return employeeDAO.getById(id);
    }

    public Employee getByEmailEmployee(String email) {
        if (email == null) return null;
        return employeeDAO.findByEmail(email);
    }


    public List<Employee> getAllEmployeesDepartment(Integer idDepartment) {

        return employeeDAO.getAll(idDepartment);

    }

}
