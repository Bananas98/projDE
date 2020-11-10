package departmentmanagement.dao;


import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;

public class MySQLDAO extends DAOFactory {

   private static MySQLDAO mySQLDAO;

   public static MySQLDAO getInstance() {
      MySQLDAO localInstance = mySQLDAO;
      if (localInstance == null) {
         synchronized (MySQLDAO.class) {
            localInstance = mySQLDAO;
            if (localInstance == null) {
               mySQLDAO = localInstance = new MySQLDAO();
            }
         }
      }
      return localInstance;
   }

   @Override
   public DepartmentDAO getDepartmentDAO() {
      return DepartmentDAOImpl.getInstance();
   }

   @Override
   public EmployeeDAO getEmployeeDAO() {
      return EmployeeDAOImpl.getInstance();
   }
}
