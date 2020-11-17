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
        ovalValidator.setValidator(department);
        mySQLDAO.getDepartmentDAO().createOrUpdate(department);
    }

    public void deleteDepartment(Integer idDepartment) throws SQLException {
        mySQLDAO.getDepartmentDAO().delete(idDepartment);
    }

    public List<Department> getAllDepartment() throws SQLException {
        return DepartmentDAOImpl.getInstance().getAll();
    }


}
