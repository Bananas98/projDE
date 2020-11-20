package departmentmanagement.service;



import departmentmanagement.dao.DAOFactory;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.validate.OvalValidator;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private final DAOFactory mySQLDAO = DAOFactory.getDAOFactory();
    private final OvalValidator ovalValidator = new OvalValidator();

    public void createOrUpdate(Employee employee) throws ValidException, SQLException {
        ovalValidator.setValidator(employee);
        mySQLDAO.getEmployeeDAO().createOrUpdate(employee);
    }

    public void deleteEmployee(Integer employeeId) throws SQLException {
        mySQLDAO.getEmployeeDAO().delete(employeeId);
    }


    public Employee getByIdEmployee(Integer id) throws SQLException {
        return mySQLDAO.getEmployeeDAO().getById(id);
    }


    public List<Employee> getAllEmployeesDepartment(Integer idDepartment) throws SQLException {
        return EmployeeDAOImpl.getInstance().getAll(idDepartment);
    }

}
