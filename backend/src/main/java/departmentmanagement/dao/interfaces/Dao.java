package departmentmanagement.dao.interfaces;

import java.sql.SQLException;

public interface Dao<T> {
    T getById(Integer id) throws SQLException;
    void delete(Integer id) throws SQLException;
    T createOrUpdate(T t) throws SQLException;
}
