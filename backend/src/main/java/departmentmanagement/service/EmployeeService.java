package departmentmanagement.service;


import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployeesDepartment(Integer idDepartment) ;

    Employee createOrUpdate(Employee employee) throws ValidException;

    void deleteEmployee(Integer id) ;

    Employee getByIdEmployee(Integer id);

    Employee getByEmailEmployee(String email);
}
