package departmentmanagement.service;

import departmentmanagement.dao.DAOFactory;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.validate.OvalValidator;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentService {

    private OvalValidator ovalValidator = new OvalValidator();
    private DAOFactory mySQLDAO = DAOFactory.getDAOFactory();


    public Department getByIdDepartment(Integer id){
        return mySQLDAO.getDepartmentDAO().get(id);
    }

    public void createNewDepartment(Department department) throws ValidException {
        validate(department);
        mySQLDAO.getDepartmentDAO().create(department);
    }

    public void deleteDepartment(int idDepartment){
        mySQLDAO.getDepartmentDAO().delete(idDepartment);
    }

    public void updateDepartment(Department department) throws ValidException {
        validate(department);
        mySQLDAO.getDepartmentDAO().update(department);
    }

    public List<Department> getAllDepartment(){
        return mySQLDAO.getDepartmentDAO().getAllDepartments();
    }

    private void validate(Object o) throws ValidException{

        Map<String, String> valid = new HashMap<>();

        this.ovalValidator.setValidator(o, valid);
        if (valid.size() > 0) {
            throw new ValidException("element not valid for department",valid);
        }
    }

}
