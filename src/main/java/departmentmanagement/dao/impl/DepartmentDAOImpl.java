package departmentmanagement.dao.impl;


import departmentmanagement.dao.DBConnection;
import departmentmanagement.dao.interfaces.DepartmentDAO;
import departmentmanagement.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    static final String DELETE_DEPARTMENT = "DELETE FROM department WHERE id = ?";
    static final String UPDATE_DEPARTMENT = "UPDATE department set name = ? WHERE id = ?";
    static final String CREATE_DEPARTMENT = "INSERT INTO department (name) VALUES (?)";
    static final String GET_ALL_DEPARTMENT = "SELECT * FROM department";
    static final String GET_DEPARTMENT = "SELECT id, name FROM department WHERE id = ?";

    private static DepartmentDAOImpl departmentDAOImpl;

    public static DepartmentDAOImpl getInstance() {
        DepartmentDAOImpl localInstance = departmentDAOImpl;
        if (localInstance == null) {
            synchronized (DepartmentDAOImpl.class) {
                localInstance = departmentDAOImpl;
                if (localInstance == null) {
                    departmentDAOImpl = localInstance = new DepartmentDAOImpl();
                }
            }
        }
        return localInstance;
    }


    @Override
    public void delete(int departmentId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(DELETE_DEPARTMENT)) {
            pStatement.setInt(1, departmentId);
            pStatement.execute();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    public Department get(int departmentId) {
        Department department = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(GET_DEPARTMENT)) {
            pStatement.setInt(1,departmentId);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()){
                department = getDepartment(resultSet);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public void create(Department department) {//todo add identifier success
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(CREATE_DEPARTMENT, Statement.RETURN_GENERATED_KEYS)) {
            pStatement.setString(1,department.getName());
            pStatement.execute();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Department department) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(UPDATE_DEPARTMENT)) {
            pStatement.setString(1, department.getName());
            pStatement.setInt(2, department.getId());
            pStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> department = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ALL_DEPARTMENT);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                department.add(getDepartment(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return department;
    }

    private Department getDepartment(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getInt("id"));
        department.setName(resultSet.getString("name"));
        return department;
    }

}
