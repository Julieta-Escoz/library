
package com.library.demo.services;

import com.library.demo.entities.Editorial;
import com.library.demo.repositories.EditorialRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService {
    
    
    @Autowired
    private EditorialRepository editorialRepo;
    
    @Transactional
    public Editorial saveEditorial (String name)throws Exception{
        
        
        validation(name);
        
        Editorial editorial = new Editorial();
        
        editorial.setName(name);
        
        
        return editorialRepo.save(editorial);
    }
    
    public List allEditorials (){
        
        return editorialRepo.findAll();
    }
    
    public void validation(String name)throws Exception{
        
        for(int i=0;i<editorialRepo.findAll().size();i++){
            Editorial e = editorialRepo.findAll().get(i);
            
            if(e.getName().equals(name)){
                throw new Exception();
            }
        }
    }
}
