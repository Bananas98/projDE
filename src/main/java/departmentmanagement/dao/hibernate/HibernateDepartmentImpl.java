package departmentmanagement.dao.hibernate;


import departmentmanagement.dao.HibernateUtil;
import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateDepartmentImpl implements Dao<Department> {

    @Override
    public Department getById(Integer id) {
        Session session = null;
        Department department = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            department = session.get(Department.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return department;
    }

    public Department findByName(String name) {
        Session session = null;
        Department department = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Department> query = session.
                    createQuery("from departmentmanagement.model.Department where name=:name");
            query.setParameter("name", name);
            department = query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return department;
    }

    @Override
    public void delete(Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM departmentmanagement.model.Department WHERE id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void create(Department department) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void update(Department department) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Department> getAll() {
        return HibernateUtil.getSessionFactory().openSession()
                .createQuery("from departmentmanagement.model.Department", Department.class).list();
    }

    @Override
    public void createOrUpdate(Department department) {
        if (department.getId() == null) {
            create(department);
        } else {
            update(department);
        }
    }
}
