package departmentmanagement.dao.impl;


import departmentmanagement.dao.DBConnection;
import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements Dao<Employee> {

    static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
    static final String UPDATE_EMPLOYEE = "UPDATE employee  set name = (?), dateOfBirthday = (?), mail = (?), salary = (?),id_department = (?) WHERE id = ?";
    static final String CREATE_EMPLOYEE = "INSERT INTO employee (name, dateOfBirthday, mail, salary, id_department) VALUES (?,?,?,?,?)";
    static final String GET_EMPLOYEE = "SELECT id, name, dateOfBirthday, mail, salary, id_department FROM employee WHERE id = ?";
    static final String GET_ALL_EMPLOYEE = "SELECT * FROM employee";
    private static final String GET_EMPLOYEE_BY_EMAIL = "SELECT * FROM employee WHERE mail=?";


    @Override
    public Employee getById(Integer idEmployee) throws SQLException {
        Employee employee = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(GET_EMPLOYEE)) {
            pStatement.setInt(1, idEmployee);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                employee = getEmployee(resultSet);
            }
        }
        return employee;
    }


    public List<Employee> getAll(Integer departmentId) throws SQLException {
        List<Employee> employeelist = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pStatement = con.prepareStatement(GET_ALL_EMPLOYEE)) {
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                if (getEmployee(resultSet).getIdDepartment().equals(departmentId)) {
                    employeelist.add(getEmployee(resultSet));
                }
            }
        }
        return employeelist;
    }

    @Override
    public void delete(Integer employeeId) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(DELETE_EMPLOYEE)) {
            pStatement.setInt(1, employeeId);
            pStatement.executeUpdate();
        }
    }


    private void create(Employee employee) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(CREATE_EMPLOYEE, Statement.RETURN_GENERATED_KEYS)) {
            pStatement.setString(1, employee.getName());
            pStatement.setDate(2, employee.getDateOfBirthday());
            pStatement.setString(3, employee.getMail());
            pStatement.setInt(4, employee.getSalary());
            pStatement.setInt(5, employee.getIdDepartment());
            pStatement.execute();
            try (ResultSet generatedKeys = pStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employee.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    private void update(Employee employee) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(UPDATE_EMPLOYEE)) {
            pStatement.setString(1, employee.getName());
            pStatement.setDate(2, employee.getDateOfBirthday());
            pStatement.setString(3, employee.getMail());
            pStatement.setInt(4, employee.getSalary());
            pStatement.setInt(5, employee.getIdDepartment());
            pStatement.setInt(6, employee.getId());
            pStatement.executeUpdate();
        }
    }

    @Override
    public void createOrUpdate(Employee employee) throws SQLException {
        if (employee.getId() == null) {
            create(employee);
        } else {
            update(employee);
        }
    }


    public Employee findByEmail(String email) throws SQLException {
        Employee employee = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_EMPLOYEE_BY_EMAIL)) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                employee = getEmployee(rs);
            }
        }
        return employee;
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
}
