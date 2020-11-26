package departmentmanagement.service;


import departmentmanagement.dao.hibernate.HibernateEmployeeImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.exception.UserSqlException;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.validate.OvalValidator;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {


    private final OvalValidator ovalValidator = new OvalValidator();
    private final HibernateEmployeeImpl employeeDAO = new HibernateEmployeeImpl();

    public void createOrUpdate(Employee employee) throws ValidException {

        if (!employee.getIdDepartment().toString().isEmpty()) {
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
