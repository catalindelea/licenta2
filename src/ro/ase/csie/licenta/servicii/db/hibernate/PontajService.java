package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ase.csie.licenta.entity.Pontaj;

@Service
@Transactional
public class PontajService{
    
	@Autowired
    private PontajDAO pontajDAO;
    
    public List<Pontaj> selectAll() {
       return pontajDAO.selectAll();
    }
    
    public Pontaj selectById(Long id) {
        return pontajDAO.selectById(id);
    }
    
    public void insert(Pontaj pontaj) {
    	pontajDAO.insert(pontaj);
    }
    
    public void update(Pontaj pontaj) {
    	pontajDAO.update(pontaj);
    }
    
    public void delete(Pontaj pontaj) {
    	pontajDAO.delete(pontaj);
    }
   
    
}
