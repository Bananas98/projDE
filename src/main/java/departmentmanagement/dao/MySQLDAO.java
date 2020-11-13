package departmentmanagement.dao;


import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.dao.interfaces.EmployeeDAO;

public class MySQLDAO extends DAOFactory {


   @Override
   public DepartmentDAO getDepartmentDAO() {
      return DepartmentDAOImpl.getInstance();
   }

   @Override
   public EmployeeDAO getEmployeeDAO() {
      return EmployeeDAOImpl.getInstance();
   }
}
