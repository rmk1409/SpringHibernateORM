package model;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by r.pogorelov on 16.09.2016.
 */
public class EmployeeDao {
    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Transactional
    public void save(Employee employee) {
        template.saveOrUpdate(employee);
    }

    public Employee getById(int id) {
        return template.get(Employee.class, id);
    }

    @Transactional
    public void update(Employee employee) {
        template.update(employee);
    }

    @Transactional
    public void delete(Employee employee) {
        template.delete(employee);
    }

    public List<Employee> getEmployees() {
        return template.loadAll(Employee.class);
    }
}
