package departmentmanagement.dao.interfaces;


import departmentmanagement.model.Employee;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    Employee get(int id) throws SQLException;
    List<Employee> getAllEmployeeDepartments(int departmentId) throws SQLException;
    void delete(int employeeId) throws SQLException;
    void create(Employee employee) throws SQLException;
    void update(Employee employee) throws SQLException;

}
