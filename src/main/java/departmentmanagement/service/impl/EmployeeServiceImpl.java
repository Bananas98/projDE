package departmentmanagement.service.impl;


import departmentmanagement.dao.hibernate.HibernateEmployeeImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.service.DepartmentService;
import departmentmanagement.service.EmployeeService;
import departmentmanagement.validate.OvalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private OvalValidator ovalValidator;

    @Autowired
    private HibernateEmployeeImpl employeeDAO;

    public void createOrUpdate(Employee employee) throws ValidException {

        if (!employee.getDepartment().getId().toString().isEmpty()) {
            ovalValidator.validate(employee);
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

    public Employee getByEmailEmployee(String email) {
        if (email == null) return null;
        return employeeDAO.findByEmail(email);
    }


    public List<Employee> getAllEmployeesDepartment(Integer idDepartment) {

        return employeeDAO.getAll(idDepartment);

    }

}
