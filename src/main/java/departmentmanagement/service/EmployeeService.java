package departmentmanagement.service;


import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.validate.OvalValidator;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {


    private final OvalValidator ovalValidator = new OvalValidator();
    private final EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    public void createOrUpdate(Employee employee) throws ValidException {
        if (!employee.getIdDepartment().toString().isEmpty()) {
            ovalValidator.setValidator(employee);
            try {
                employeeDAO.createOrUpdate(employee);
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
    }

    public void deleteEmployee(Integer employeeId) {
        if (employeeId != null) {
            try {
                employeeDAO.delete(employeeId);
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
    }


    public Employee getByIdEmployee(Integer id) {
        if (id == null) return null;
        try {
            return employeeDAO.getById(id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    public List<Employee> getAllEmployeesDepartment(Integer idDepartment) {
        try {
            return employeeDAO.getAll(idDepartment);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
