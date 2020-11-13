package departmentmanagement.service;



import departmentmanagement.dao.DAOFactory;
import departmentmanagement.model.Employee;

import java.sql.Date;
import java.util.List;

public class EmployeeService {

    private DAOFactory mySQLDAO = DAOFactory.getDAOFactory();


    public void createNewEmployee(String departmentName , Date dateOfBirthday, String mail, int salary, int idDepartment){
        mySQLDAO.getEmployeeDAO().create(departmentName, dateOfBirthday, mail, salary, idDepartment);
    }

    public void deleteEmployee(int employeeId){
        mySQLDAO.getEmployeeDAO().delete(employeeId);
    }

    public void updateEmployee(int idEmployee, String employeeName, Date dateOfBirthday, String mail, int salary, int idDepartment){
        mySQLDAO.getEmployeeDAO().update(idEmployee, employeeName,dateOfBirthday,mail,salary,idDepartment);
    }

    public List<Employee> getAllEmployeesDepartment(int idDepartment){
        return mySQLDAO.getEmployeeDAO().getAllEmployeeDepartments(idDepartment);
    }
}
