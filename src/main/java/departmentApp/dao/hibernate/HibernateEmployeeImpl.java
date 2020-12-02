package departmentApp.dao.hibernate;

import departmentApp.dao.HibernateUtil;
import departmentApp.dao.interfaces.Dao;
import departmentApp.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.UnknownProfileException;
import org.hibernate.query.Query;

import java.util.List;


public class HibernateEmployeeImpl implements Dao<Employee> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Employee getById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
            }
            session.getTransaction().commit();
        } catch (UnknownProfileException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
        }
    }


    @Override
    public void createOrUpdate(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(employee);
            session.getTransaction().commit();
        } catch (UnknownProfileException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
        }
    }

    public List<Employee> getAll(Integer departmentId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Employee> query = session
                    .createQuery("from Employee where id_department=:departmentId", Employee.class);
            query.setParameter("departmentId", departmentId);
            return query.list();
        }
    }

    public Employee findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<Employee> query = session.createQuery("from Employee where mail=:email");
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }
}
