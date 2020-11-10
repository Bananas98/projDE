package departmentmanagement.dao;


import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;

public abstract class DAOFactory {

    public static DAOFactory getDAOFactory() {
        return new MySQLDAO();
    }

    public abstract DepartmentDAO getDepartmentDAO();

    public abstract EmployeeDAO getEmployeeDAO();
}
