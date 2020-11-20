package departmentmanagement.dao.impl;


import departmentmanagement.dao.DBConnection;
import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements Dao<Department> {

    static final String DELETE_DEPARTMENT = "DELETE FROM department WHERE id = ?";
    static final String UPDATE_DEPARTMENT = "UPDATE department set name = ? WHERE id = ?";
    static final String CREATE_DEPARTMENT = "INSERT INTO department (name) VALUES (?)";
    static final String GET_ALL_DEPARTMENT = "SELECT * FROM department";
    static final String GET_DEPARTMENT = "SELECT id, name FROM department WHERE id = ?";
    private static final String GET_DEPARTMENT_BY_NAME = "SELECT * FROM department WHERE name=?";

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
    public void delete(Integer departmentId) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(DELETE_DEPARTMENT)) {
            pStatement.setInt(1, departmentId);
            pStatement.execute();
        }
    }

    public Department getById(Integer departmentId) throws SQLException {
        Department department = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(GET_DEPARTMENT)) {
            pStatement.setInt(1, departmentId);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                department = getDepartment(resultSet);
            }
        }
        return department;
    }

    private void create(Department department) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(CREATE_DEPARTMENT)) {
            pStatement.setString(1, department.getName());
            pStatement.execute();
        }
    }

    private void update(Department department) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(UPDATE_DEPARTMENT)) {
            pStatement.setString(1, department.getName());
            pStatement.setInt(2, department.getId());
            pStatement.execute();
        }
    }

    @Override
    public void createOrUpdate(Department entity) throws SQLException {
        Integer id = entity.getId();
        if (id == null) {
            create(entity);
        } else {
            update(entity);
        }
    }

    @Override
    public boolean isUnique(Department department) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_DEPARTMENT_BY_NAME)) {
             statement.setString(1, department.getName());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (department.getId() == null || (department.getId() != rs.getInt("id"))) {
                    return true;
                }
            }
            return false;
        }
}

    public List<Department> getAll() throws SQLException {
        List<Department> department = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ALL_DEPARTMENT);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                department.add(getDepartment(resultSet));
            }
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
