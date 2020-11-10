package departmentmanagement.dao.impl;


import departmentmanagement.dao.DBConnection;
import departmentmanagement.dao.interfaces.EmployeeDAO;
import departmentmanagement.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();

    static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
    static final String UPDATE_EMPLOYEE = "UPDATE employee  set name = (?), dateOfBirthday = (?), mail = (?), salary = (?),id_department = (?) WHERE id = ?";
    static final String CREATE_EMPLOYEE = "INSERT INTO employee (name, dateOfBirthday, mail, salary, id_department) VALUES (?,?,?,?,?)";
//    static final String GET_ALL_EMPLOYEE = "SELECT e.id, e.name, e.dateOfBirthday, e.mail, e.salary, d.id AS departmentId, d.name FROM employee AS e " +
//            "JOIN department AS d ON (e.id_department = d.id) WHERE id_department = ?";
    static final String GET_EMPLOYEE = "SELECT id, name, dateOfBirthday, mail, salary, id_department FROM employee WHERE id = ?";
    static final String GET_ALL_EMPLOYEE = "SELECT * FROM employee";

    private static EmployeeDAOImpl employeeDAOImpl;

    public static EmployeeDAOImpl getInstance() {
        EmployeeDAOImpl localInstance = employeeDAOImpl;
        if (localInstance == null) {
            synchronized (EmployeeDAOImpl.class) {
                localInstance = employeeDAOImpl;
                if (localInstance == null) {
                    employeeDAOImpl = localInstance = new EmployeeDAOImpl();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Employee get(int idEmployee) {
        Employee employee = null;
        try (Connection connection =  DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(GET_EMPLOYEE)){
             pStatement.setInt(1,idEmployee);
             ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()){
                employee = getEmployee(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }



    @Override
    public List<Employee> getAllEmployeeDepartments(int departmentId) {
        List<Employee> employeelist = new ArrayList<>();
        try(Connection con = DBConnection.getConnection();
            PreparedStatement pStatement = con.prepareStatement(GET_ALL_EMPLOYEE)){
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()){
                if (getEmployee(resultSet).getIdDepartment() == departmentId){
                    employeelist.add(getEmployee(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeelist;
    }

    @Override
    public void delete(int employeeId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(DELETE_EMPLOYEE)) {
            pStatement.setInt(1, employeeId);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(String employeeName, Date dateOfBirthday, String mail, int salary, int idDepartment) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(CREATE_EMPLOYEE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pStatement.setString(1, employeeName);
            pStatement.setDate(2, dateOfBirthday);
            pStatement.setString(3, mail);
            pStatement.setInt(4, salary);
            pStatement.setInt(5, idDepartment);
            pStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String nameEmployee, Date dateOfBirthday, String mail, int salary, int departmentId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(UPDATE_EMPLOYEE);) {
            pStatement.setString(1,nameEmployee);
            pStatement.setDate(2,dateOfBirthday);
            pStatement.setString(3,mail);
            pStatement.setInt(4,salary);
            pStatement.setInt(5,departmentId);
            pStatement.setInt(6,departmentId);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Employee getEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setDateOfBirthday(resultSet.getDate("dateOfBirthday"));
        employee.setMail(resultSet.getString("mail"));
        employee.setSalary(resultSet.getInt("salary"));
        employee.setIdDepartment(resultSet.getInt("id_department"));
        return employee;
    }

    private void setEmployee(PreparedStatement pStatement, Employee emp) throws SQLException{
        pStatement.setString(1, emp.getName());
        pStatement.setDate(2, emp.getDateOfBirthday());
        pStatement.setString(3, emp.getMail());
        pStatement.setDouble(4, emp.getSalary());
        pStatement.setInt(5, emp.getIdDepartment());
    }
}
