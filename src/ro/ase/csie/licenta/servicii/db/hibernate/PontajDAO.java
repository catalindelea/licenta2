package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ase.csie.licenta.entity.Pontaj;

@Repository
@Transactional
public class PontajDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
    
	@SuppressWarnings("unchecked")
	public List<Pontaj> selectAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pontaj.class);
        return criteria.list();
    }

	public Pontaj selectById(Long id) {
        return (Pontaj) sessionFactory.getCurrentSession().get(Pontaj.class,id);
    }

    public void insert(Pontaj obj) {
       sessionFactory.getCurrentSession().save(obj);
    }
    

    public void update(Pontaj obj) {
    	sessionFactory.getCurrentSession().update(obj);
    }

    public void delete(Pontaj obj) {
    	sessionFactory.getCurrentSession().delete(obj);
    }

}
