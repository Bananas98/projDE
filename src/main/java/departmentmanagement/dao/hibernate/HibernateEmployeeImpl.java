package departmentmanagement.dao.hibernate;

import departmentmanagement.dao.HibernateUtil;
import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class HibernateEmployeeImpl implements Dao<Employee> {

    @Override
    public Employee getById(Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public void delete(Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Employee employee = session.get(Employee.class,id);
            if (employee != null){
                session.delete(employee);
            }
            session.getTransaction().commit();
        }
    }


    @Override
    public void createOrUpdate(Employee employee) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(employee);
            session.getTransaction().commit();
        }
    }

    public List<Employee> getAll(Integer departmentId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Query<Employee> query = session
                    .createQuery("from Employee where id_department=:departmentId", Employee.class);
            query.setParameter("departmentId", departmentId);
            return query.list();
        }
    }

    public Employee findByEmail(String email) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<Employee> query = session.
                    createQuery("from Employee where mail=:email");
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }
}
