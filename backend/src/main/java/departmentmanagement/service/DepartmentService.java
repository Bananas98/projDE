package departmentmanagement.service;

import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;

import java.util.List;


public interface DepartmentService {
    List<Department> getAllDepartment() ;

    void createOrUpdateDepartment(Department department);
            //throws  ValidException;

    void deleteDepartment(Integer id) ;

    Department getByIdDepartment(Integer id);

    Department getByNameDepartment(String name);
}
