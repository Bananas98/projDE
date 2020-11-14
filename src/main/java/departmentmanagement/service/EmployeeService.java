package departmentmanagement.service;



import departmentmanagement.dao.DAOFactory;
import departmentmanagement.model.Employee;

import java.sql.Date;
import java.util.List;

public class EmployeeService {

    private DAOFactory mySQLDAO = DAOFactory.getDAOFactory();


    public void createNewEmployee(Employee employee){
        mySQLDAO.getEmployeeDAO().create(employee);
    }

    public void deleteEmployee(int employeeId){
        mySQLDAO.getEmployeeDAO().delete(employeeId);
    }

    public void updateEmployee(Employee employee){
        mySQLDAO.getEmployeeDAO().update(employee);
    }

    public Employee getByIdEmployee(Integer id){
        return mySQLDAO.getEmployeeDAO().get(id);
    }


    public List<Employee> getAllEmployeesDepartment(int idDepartment){
        return mySQLDAO.getEmployeeDAO().getAllEmployeeDepartments(idDepartment);
    }
}
