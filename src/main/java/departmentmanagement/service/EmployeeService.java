package departmentmanagement.service;



import departmentmanagement.dao.DAOFactory;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.validate.OvalValidator;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {

    private DAOFactory mySQLDAO = DAOFactory.getDAOFactory();
    private OvalValidator ovalValidator = new OvalValidator();

    public void createOrUpdate(Employee employee) throws ValidException, SQLException {
        validate(employee);
        mySQLDAO.getEmployeeDAO().createOrUpdate(employee);
    }

    public void deleteEmployee(int employeeId) throws SQLException {
        mySQLDAO.getEmployeeDAO().delete(employeeId);
    }


    public Employee getByIdEmployee(Integer id) throws SQLException {
        return mySQLDAO.getEmployeeDAO().getById(id);
    }


    public List<Employee> getAllEmployeesDepartment(int idDepartment) throws SQLException {
        return EmployeeDAOImpl.getInstance().getAll(idDepartment);
    }

    private void validate(Object o) throws ValidException {

        Map<String, String> valid = new HashMap<>();

        this.ovalValidator.setValidator(o, valid);
        if (valid.size() > 0) {
            throw new ValidException("element not valid for employee",valid);
        }
    }
}
