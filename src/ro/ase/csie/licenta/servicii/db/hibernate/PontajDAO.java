package ro.ase.csie.licenta.servicii.db.hibernate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ase.csie.licenta.entity.Corectie;
import ro.ase.csie.licenta.entity.Pontaj;
import ro.ase.csie.licenta.util.UtilZile;

@Repository
@Transactional
public class PontajDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Pontaj> selectAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pontaj.class);
		return criteria.list();
	}

	public Pontaj selectById(Long id) {
		return (Pontaj) sessionFactory.getCurrentSession().get(Pontaj.class, id);
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

	public List<Pontaj> selectIeriForAngajat(Date data, long id_angajat) {
		List<Pontaj> lista = new ArrayList<Pontaj>();
		Date midnight = UtilZile.midnight(data);
		Date tMidnight = UtilZile.tMidnight(data);
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Pontaj where id_angajat= :id_angajat and data_io BETWEEN :data_m and :data_M");
			query.setParameter("id_angajat", id_angajat);
			query.setDate("data_m", midnight);
			query.setDate("data_M", tMidnight);
			lista = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Pontaj> selectOnMonthForAngajat(Date data, long id_angajat) {
		List<Pontaj> lista = new ArrayList<Pontaj>();
		Date inceputulLunii = UtilZile.startOfLastMonth(data);
		Date sfarsitulLunii = UtilZile.endOfLastMonth(data);
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Pontaj where id_angajat= :id_angajat and data_io BETWEEN :data_m and :data_M");
			query.setParameter("id_angajat", id_angajat);
			query.setDate("data_m", inceputulLunii);
			query.setDate("data_M", sfarsitulLunii);
			lista = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
