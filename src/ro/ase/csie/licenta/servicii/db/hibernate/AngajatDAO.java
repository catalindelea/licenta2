package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ase.csie.licenta.entity.Angajat;
import ro.ase.csie.licenta.entity.Manager;
import ro.ase.csie.licenta.entity.Pontaj;
import ro.ase.csie.licenta.util.UtilZile;

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
    
    public String getEmailAddressForManager(Long id_angajat){
    	ArrayList<Manager> lista  = new ArrayList<Manager>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Manager where id_manager= :id_manager");
			query.setParameter("id_manager", Services.getAngajatService().selectById(id_angajat).getId_manager());
			lista = (ArrayList<Manager>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista.get(0).getEmail();
    }

}
