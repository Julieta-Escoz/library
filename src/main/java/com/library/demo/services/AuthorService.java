
package com.library.demo.services;

import com.library.demo.entities.Author;
import com.library.demo.repositories.AuthorRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepo;
    
    @Transactional
    public Author saveAuthor (String name, String picture)throws Exception{
        
        validation(name);
        
        Author author = new Author();
        
        author.setName(name);
        author.setPicture(picture);
        
        return authorRepo.save(author);
    }
    
    @Transactional
    public List allAuthors (){
        
        return authorRepo.findAll();
    }
    
    public void validation(String name)throws Exception{
        
        for(int i=0;i<authorRepo.findAll().size();i++){
            Author a = authorRepo.findAll().get(i);
            
            if(a.getName().equals(name)){
                throw new Exception();
            }
        }
    }
}
