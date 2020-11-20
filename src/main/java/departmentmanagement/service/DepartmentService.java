package departmentmanagement.service;

import departmentmanagement.dao.DAOFactory;
import departmentmanagement.dao.impl.DepartmentDAOImpl;
import departmentmanagement.exception.ValidException;
import departmentmanagement.model.Department;
import departmentmanagement.validate.OvalValidator;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {

    private OvalValidator ovalValidator = new OvalValidator();
    private DAOFactory mySQLDAO = DAOFactory.getDAOFactory();


    public Department getByIdDepartment(Integer id) throws SQLException {
        if (id==null) return null;
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
