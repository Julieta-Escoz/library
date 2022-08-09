
package com.library.demo.controllers;

import com.library.demo.entities.Author;
import com.library.demo.entities.Book;
import com.library.demo.entities.Editorial;
import com.library.demo.services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    
    @Autowired
    private BookService bookServ;
    
    
    @GetMapping("/booksave")
    public String formulario(){
        return "book-save";
    }
    
    @PostMapping("/booksave")
    public String booksave(ModelMap modelo, @RequestParam Integer isbn, @RequestParam String title, @RequestParam Integer year, @RequestParam Author author, @RequestParam Editorial editorial, @RequestParam String frontImage, @RequestParam Integer copies)throws Exception{
        try{
            Book book = bookServ.createBook(isbn, title, year, author, editorial, frontImage, copies);
            
            // monstrar mensaje de exito al cargar ("llave","mensaje")
            modelo.put("exito","The registration was successful");
            
        }catch (Exception e){
            modelo.put("error","Error, data is missing, try again.");
            throw e;
        }
        
        return "book-save";
    }
    
    
    
        @GetMapping("/booklist")
    public String lista (ModelMap modelo){
      List<Book> books = bookServ.findAllBooks();
      
      modelo.addAttribute("books", books);
      
      return "book-list";
    }
}
