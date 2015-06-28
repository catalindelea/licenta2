package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ase.csie.licenta.entity.Corectie;

@Repository
@Transactional
public class CorectieDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
    
	@SuppressWarnings("unchecked")
	public List<Corectie> selectAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Corectie.class);
        return criteria.list();
    }

	public Corectie selectById(Long id) {
        return (Corectie) sessionFactory.getCurrentSession().get(Corectie.class,id);
    }

    public void insert(Corectie obj) {
       sessionFactory.getCurrentSession().save(obj);
    }
    

    public void update(Corectie obj) {
    	sessionFactory.getCurrentSession().update(obj);
    }

    public void delete(Corectie obj) {
    	sessionFactory.getCurrentSession().delete(obj);
    }

}
