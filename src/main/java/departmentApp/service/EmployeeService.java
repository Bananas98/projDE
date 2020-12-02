package departmentApp.service;


import departmentApp.dao.hibernate.HibernateEmployeeImpl;
import departmentApp.exception.ValidException;
import departmentApp.model.Employee;
import departmentApp.validate.OvalValidator;

import java.util.List;

public class EmployeeService {


    private final OvalValidator ovalValidator = new OvalValidator();
    private final HibernateEmployeeImpl employeeDAO = new HibernateEmployeeImpl();

    public void createOrUpdate(Employee employee) throws ValidException {

        if (!employee.getDepartment().getId().toString().isEmpty()) {
            ovalValidator.setValidator(employee);
            employeeDAO.createOrUpdate(employee);
        }
    }

    public void deleteEmployee(Integer employeeId) {

        if (employeeId != null) {
            employeeDAO.delete(employeeId);
        }

    }


    public Employee getByIdEmployee(Integer id) {
        if (id == null) return null;
        return employeeDAO.getById(id);
    }


    public List<Employee> getAllEmployeesDepartment(Integer idDepartment) {

        return employeeDAO.getAll(idDepartment);

    }

}
