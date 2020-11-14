package departmentmanagement.dao.interfaces;


import departmentmanagement.model.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeDAO {
    Employee get(int id);
    List<Employee> getAllEmployeeDepartments(int departmentId);
    void delete(int employeeId);
    void create(Employee employee);
    void update(Employee employee);

}
