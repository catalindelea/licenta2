package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ase.csie.licenta.entity.Manager;

@Service
@Transactional
public class ManagerService{
    
	@Autowired
    private ManagerDAO managerDAO;
    
    public List<Manager> selectAll() {
       return managerDAO.selectAll();
    }
    
    public Manager selectById(Long id) {
        return managerDAO.selectById(id);
    }
    
    public void insert(Manager manager) {
    	managerDAO.insert(manager);
    }
    
    public void update(Manager manager) {
    	managerDAO.update(manager);
    }
    
    public void delete(Manager manager) {
    	managerDAO.delete(manager);
    }
   
    
}
