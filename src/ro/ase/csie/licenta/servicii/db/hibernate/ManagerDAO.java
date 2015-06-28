package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ase.csie.licenta.entity.Manager;

@Repository
@Transactional
public class ManagerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
    
	@SuppressWarnings("unchecked")
	public List<Manager> selectAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Manager.class);
        return criteria.list();
    }

	public Manager selectById(Long id) {
        return (Manager) sessionFactory.getCurrentSession().get(Manager.class,id);
    }

    public void insert(Manager obj) {
       sessionFactory.getCurrentSession().save(obj);
    }
    

    public void update(Manager obj) {
    	sessionFactory.getCurrentSession().update(obj);
    }

    public void delete(Manager obj) {
    	sessionFactory.getCurrentSession().delete(obj);
    }

}
