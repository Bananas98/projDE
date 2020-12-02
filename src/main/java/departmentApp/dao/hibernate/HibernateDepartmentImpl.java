package departmentApp.dao.hibernate;


import departmentApp.dao.HibernateUtil;
import departmentApp.dao.interfaces.Dao;
import departmentApp.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.UnknownProfileException;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateDepartmentImpl implements Dao<Department> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Department getById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Department.class, id);
        }
    }

    public Department findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Department> query = session
                    .createQuery("from Department where name=:name");
            query.setParameter("name", name);
            return query.uniqueResult();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Department department = session.get(Department.class, id);
            if (department != null) {
                session.delete(department);
            }
            session.getTransaction().commit();
        } catch (UnknownProfileException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
        }
    }

    public List<Department> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Department", Department.class).list();
        }
    }

    @Override
    public void createOrUpdate(Department department) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(department);
            session.getTransaction().commit();
        } catch (UnknownProfileException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
        }
    }
}
