package departmentmanagement.dao;


import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.dao.impl.EmployeeDAOImpl;
import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Department;
import departmentmanagement.model.Employee;

public class MySQLDAO extends DAOFactory {


   @Override
   public Dao<Department> getDepartmentDAO() {
      return DepartmentDAOImpl.getInstance();
   }

   @Override
   public Dao<Employee>getEmployeeDAO() {
      return EmployeeDAOImpl.getInstance();
   }
}
