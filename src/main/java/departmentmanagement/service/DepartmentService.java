package departmentmanagement.service;

import departmentmanagement.dao.DAOFactory;
import departmentmanagement.model.Department;

import java.util.List;

public class DepartmentService {


    private DAOFactory mySQLDAO = DAOFactory.getDAOFactory();

    private static DepartmentService departmentService;

    private DepartmentService() {

    }


    public void createNewDepartment(String nameDepartment){
        mySQLDAO.getDepartmentDAO().create(nameDepartment);
    }

    public void deleteDepartment(int idDepartment){
        mySQLDAO.getDepartmentDAO().delete(idDepartment);
    }

    public void updateDepartment(int departmentId, String nameDepartment ){
        mySQLDAO.getDepartmentDAO().update(departmentId, nameDepartment);
    }

    public List<Department> getAllDepartment(){
        return mySQLDAO.getDepartmentDAO().getAllDepartments();
    }



}
