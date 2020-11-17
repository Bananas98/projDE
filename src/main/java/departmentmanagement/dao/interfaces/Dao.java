package departmentmanagement.dao.interfaces;

import departmentmanagement.model.Department;

import java.sql.SQLException;

public interface Dao<T> {
    T getById(int id) throws SQLException;
    void delete(int id) throws SQLException;
    void createOrUpdate(T t) throws SQLException;
}
