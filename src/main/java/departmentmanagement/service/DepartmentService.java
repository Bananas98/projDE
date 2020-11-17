package departmentmanagement.service;

import departmentmanagement.dao.DAOFactory;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.validate.OvalValidator;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentService {

    private OvalValidator ovalValidator = new OvalValidator();
    private DAOFactory mySQLDAO = DAOFactory.getDAOFactory();


    public Department getByIdDepartment(Integer id) throws SQLException {
        return mySQLDAO.getDepartmentDAO().getById(id);
    }

    public void createOrUpdateDepartment(Department department) throws ValidException, SQLException {
        validate(department);
        mySQLDAO.getDepartmentDAO().createOrUpdate(department);
    }

    public void deleteDepartment(int idDepartment) throws SQLException {
        mySQLDAO.getDepartmentDAO().delete(idDepartment);
    }

    public List<Department> getAllDepartment() throws SQLException {
        return DepartmentDAOImpl.getInstance().getAll();
    }

    private void validate(Object o) throws ValidException{

        Map<String, String> valid = new HashMap<>();

        this.ovalValidator.setValidator(o, valid);
        if (valid.size() > 0) {
            throw new ValidException("element not valid for department",valid);
        }
    }

}
