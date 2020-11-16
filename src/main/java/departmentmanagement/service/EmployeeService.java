package departmentmanagement.service;



import departmentmanagement.dao.DAOFactory;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;
import departmentmanagement.validate.OvalValidator;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {

    private DAOFactory mySQLDAO = DAOFactory.getDAOFactory();
    private OvalValidator ovalValidator = new OvalValidator();

    public void createNewEmployee(Employee employee) throws ValidException {
        validate(employee);
        mySQLDAO.getEmployeeDAO().create(employee);
    }

    public void deleteEmployee(int employeeId){
        mySQLDAO.getEmployeeDAO().delete(employeeId);
    }

    public void updateEmployee(Employee employee) throws ValidException {
        validate(employee);
        mySQLDAO.getEmployeeDAO().update(employee);
    }

    public Employee getByIdEmployee(Integer id){
        return mySQLDAO.getEmployeeDAO().get(id);
    }


    public List<Employee> getAllEmployeesDepartment(int idDepartment){
        return mySQLDAO.getEmployeeDAO().getAllEmployeeDepartments(idDepartment);
    }

    private void validate(Object o) throws ValidException {

        Map<String, String> valid = new HashMap<>();

        this.ovalValidator.setValidator(o, valid);
        if (valid.size() > 0) {
            throw new ValidException("element not valid for employee",valid);
        }
    }
}
