package departmentApp.dao.interfaces;

import java.sql.SQLException;

public interface Dao<T> {
    T getById(Integer id) throws SQLException;
    void delete(Integer id) throws SQLException;
    void createOrUpdate(T t) throws SQLException;
}
