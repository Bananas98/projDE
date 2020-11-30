package departmentmanagement.dao.hibernate;


import departmentmanagement.dao.HibernateUtil;
import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateDepartmentImpl implements Dao<Department> {

    @Override
    public Department getById(Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            return session.get(Department.class, id);
        }
    }

    public Department findByName(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<Department> query = session.
                    createQuery("from departmentmanagement.model.Department where name=:name");
            query.setParameter("name", name);
            return query.uniqueResult();
        }
    }

    @Override
    public void delete(Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Department department = session.get(Department.class,id);
            if (department != null){
                session.delete(department);
            }
            session.getTransaction().commit();
        }
    }

    public List<Department> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from departmentmanagement.model.Department", Department.class).list();
        }
    }

    @Override
    public void createOrUpdate(Department department) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.saveOrUpdate(department);
            session.getTransaction().commit();
        }
    }
}
