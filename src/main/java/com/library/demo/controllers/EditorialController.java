
package com.library.demo.controllers;

import com.library.demo.entities.Editorial;
import com.library.demo.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditorialController {
    
    @Autowired
    private EditorialService editorialServ;
    
    @PostMapping("/editorialsave")
    public String booksave(ModelMap modelo, String name)throws Exception{
        
        try{
           
            
            Editorial editorial = editorialServ.saveEditorial(name);
            
            // monstrar mensaje de exito al cargar ("llave","mensaje")
            modelo.put("exito","The registration was successful");
            
        }catch (Exception e){
            modelo.put("error","Error, data is missing, try again.");
            throw e;
        }
        
        return "author-save";
    }
}

//vía mail a 

