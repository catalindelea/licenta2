package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ase.csie.licenta.entity.Angajat;

@Repository
@Transactional
public class AngajatDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
    
	@SuppressWarnings("unchecked")
	public List<Angajat> selectAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Angajat.class);
        return criteria.list();
    }

	public Angajat selectById(Long id) {
        return (Angajat) sessionFactory.getCurrentSession().get(Angajat.class,id);
    }

    public void insert(Angajat obj) {
       sessionFactory.getCurrentSession().save(obj);
    }
    

    public void update(Angajat obj) {
    	sessionFactory.getCurrentSession().update(obj);
    }

    public void delete(Angajat obj) {
    	sessionFactory.getCurrentSession().delete(obj);
    }

}
