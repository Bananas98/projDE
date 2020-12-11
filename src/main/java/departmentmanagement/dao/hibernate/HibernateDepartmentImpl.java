package departmentmanagement.dao.hibernate;


import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Department;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class HibernateDepartmentImpl implements Dao<Department> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public Department getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Department.class, id);
    }

    public Department findByName(String name) {
        Query<Department> query = sessionFactory.getCurrentSession()
                .createQuery("from departmentmanagement.model.Department where name=:name", Department.class);
        query.setParameter("name", name);
        return query.uniqueResult();
    }


    @Override
    public void delete(Integer id) {
        Department department = sessionFactory.getCurrentSession().get(Department.class, id);
        sessionFactory.getCurrentSession().delete(department);
    }

    public List<Department> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from departmentmanagement.model.Department", Department.class).list();
    }

    @Override
    public void createOrUpdate(Department department) {
        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }
}
