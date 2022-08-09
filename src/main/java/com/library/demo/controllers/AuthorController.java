
package com.library.demo.controllers;

import com.library.demo.entities.Author;
import com.library.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    
    @Autowired
    private AuthorService authorServ;
    
    @GetMapping("/authorsave")
    public String form(){
        return "author-save";
    }
    
    @PostMapping("/authorsave")
    public String booksave(ModelMap modelo, String name, String picture)throws Exception{
        
        try{
            authorServ.validation(name);
            
            Author author = authorServ.saveAuthor(name, picture);
            
            // monstrar mensaje de exito al cargar ("llave","mensaje")
            modelo.put("exito","The registration was successful");
            
        }catch (Exception e){
            modelo.put("error","Error, data is missing, try again.");
            throw e;
        }
        
        return "author-save";
    }
    
}
