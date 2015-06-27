package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ObjectDAO{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;
    private Transaction tx=null;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Object> selectAll(Class classNume) {
        List<Object> lista = new ArrayList<Object>();
        session = sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            lista = session.createCriteria(classNume).list();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lista;
    }

    @SuppressWarnings("rawtypes")
	public Object selectById(Class classNume, Integer id) {
        Object temp=null;
        try {
            session = sessionFactory.openSession();
            temp=(Object)session.get(classNume, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return temp;
    }

    public void insert(Object obj) {
       try {
           session = sessionFactory.openSession();
           tx=session.beginTransaction();
           session.save(obj);
           tx.commit();
       } catch (HibernateException e) {
           e.printStackTrace();
       } finally {
           session.close();
       }
    }
    

    public void update(Object obj) {
        try {
            session = sessionFactory.openSession();
            tx=session.beginTransaction();
            session.update(obj);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(Object obj) {
        try {
            session = sessionFactory.openSession();
            tx=session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
