package departmentmanagement.dao.interfaces;


import departmentmanagement.model.Department;

import java.util.List;

public interface DepartmentDAO {

    Department get(int departmentId);
    List<Department> getAllDepartments();
    void delete(int departmentId);
    void create(Department department);
    void update(Department department);


}
