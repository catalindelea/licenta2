package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ase.csie.licenta.entity.Angajat;

@Service
@Transactional
public class AngajatService{
    
	@Autowired
    private AngajatDAO angajatDAO;
    
    public List<Angajat> selectAll() {
       return angajatDAO.selectAll();
    }
    
    public Angajat selectById(Long id) {
        return angajatDAO.selectById(id);
    }
    
    public void insert(Angajat angajat) {
    	angajatDAO.insert(angajat);
    }
    
    public void update(Angajat angajat) {
    	angajatDAO.update(angajat);
    }
    
    public void delete(Angajat angajat) {
    	angajatDAO.delete(angajat);
    }
   
    
}
