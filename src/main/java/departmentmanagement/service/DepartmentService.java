package departmentmanagement.service;

import departmentmanagement.dao.DAOFactory;
import departmentmanagement.model.Department;
import departmentmanagement.model.Employee;

import java.util.List;

public class DepartmentService {


    private DAOFactory mySQLDAO = DAOFactory.getDAOFactory();


    public Department getByIdDepartment(Integer id){
        return mySQLDAO.getDepartmentDAO().get(id);
    }

    public void createNewDepartment(Department department){
        mySQLDAO.getDepartmentDAO().create(department);
    }

    public void deleteDepartment(int idDepartment){
        mySQLDAO.getDepartmentDAO().delete(idDepartment);
    }

    public void updateDepartment(Department department){
        mySQLDAO.getDepartmentDAO().update(department);
    }

    public List<Department> getAllDepartment(){
        return mySQLDAO.getDepartmentDAO().getAllDepartments();
    }



}
