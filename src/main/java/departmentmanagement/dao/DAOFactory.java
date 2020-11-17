package departmentmanagement.dao;


import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Department;
import departmentmanagement.model.Employee;

public abstract class DAOFactory {

    public static DAOFactory getDAOFactory() {
        return new MySQLDAO();
    }

    public abstract Dao<Department> getDepartmentDAO();

    public abstract Dao<Employee> getEmployeeDAO();
}
