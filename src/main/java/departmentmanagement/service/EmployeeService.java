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

    public void createOrUpdate(Employee employee) throws ValidException, SQLException {
        ovalValidator.setValidator(employee);
        employeeDAO.createOrUpdate(employee);
    }

    public void deleteEmployee(Integer employeeId) throws SQLException {
        employeeDAO.delete(employeeId);
    }


    public Employee getByIdEmployee(Integer id) throws SQLException {
        return employeeDAO.getById(id);
    }


    public List<Employee> getAllEmployeesDepartment(Integer idDepartment) throws SQLException {
        return employeeDAO.getAll(idDepartment);
    }

}
