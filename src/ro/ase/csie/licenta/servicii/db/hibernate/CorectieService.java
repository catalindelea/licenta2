package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ase.csie.licenta.entity.Corectie;

@Service
@Transactional
public class CorectieService{
    
	@Autowired
    private CorectieDAO corectieDAO;
    
    public List<Corectie> selectAll() {
       return corectieDAO.selectAll();
    }
    
    public Corectie selectById(Long id) {
        return corectieDAO.selectById(id);
    }
    
    public void insert(Corectie corectie) {
    	corectieDAO.insert(corectie);
    }
    
    public void update(Corectie corectie) {
    	corectieDAO.update(corectie);
    }
    
    public void delete(Corectie corectie) {
    	corectieDAO.delete(corectie);
    }
   
    
}
