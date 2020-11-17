package departmentmanagement.dao.interfaces;


import departmentmanagement.model.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {

    Department get(int departmentId) throws SQLException;
    List<Department> getAllDepartments() throws SQLException;
    void delete(int departmentId) throws SQLException;
    void create(Department department) throws SQLException;
    void update(Department department) throws SQLException;


}
