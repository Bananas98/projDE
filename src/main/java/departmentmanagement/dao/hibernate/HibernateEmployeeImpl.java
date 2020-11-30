package departmentmanagement.dao.hibernate;

import departmentmanagement.dao.HibernateUtil;
import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Department;
import departmentmanagement.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;


public class HibernateEmployeeImpl implements Dao<Employee> {

    @Override
    public Employee getById(Integer id) {
        Session session = null;
        Employee employee = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            employee = session.get(Employee.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employee;
    }

    @Override
    public void delete(Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM departmentmanagement.model.Employee WHERE id = :id");
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

    @Override
    public void createOrUpdate(Employee employee) {
        if (employee.getId() == null) {
            create(employee);
        } else {
            update(employee);
        }
    }

    private void create(Employee employee) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void update(Employee employee) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Employee> getAll(Integer departmentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Employee> query  = session
                .createQuery("from departmentmanagement.model.Employee where id_department=:departmentId", Employee.class);
        query.setParameter("departmentId",departmentId);
        return query.list();
    }

    public Employee findByEmail(String email) {
        Session session = null;
        Employee employee = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Employee> query = session.
                    createQuery("from departmentmanagement.model.Employee where mail=:email");
            query.setParameter("email", email);
            employee = query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employee;
    }
}
