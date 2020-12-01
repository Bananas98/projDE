package departmentmanagement.dao.hibernate;

import departmentmanagement.dao.interfaces.Dao;
import departmentmanagement.model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HibernateEmployeeImpl implements Dao<Employee> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Employee getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);

    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Integer id) {
        Employee employee = sessionFactory.getCurrentSession().get(Employee.class, id);
        sessionFactory.getCurrentSession().delete(employee);
    }


    @Override
    public void createOrUpdate(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAll(Integer departmentId) {
        Query<Employee> query = sessionFactory
                .getCurrentSession()
                .createQuery("from Employee where id_department=:departmentId", Employee.class);
        query.setParameter("departmentId", departmentId);
        return query.list();
    }


    @Transactional(readOnly = true)
    public Employee findByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee where mail=:email");
        query.setParameter("email", email);
        return (Employee) query.uniqueResult();
    }
}

