
package com.library.demo.services;

import com.library.demo.entities.Author;
import com.library.demo.entities.Book;
import com.library.demo.entities.Editorial;
import com.library.demo.repositories.BookRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepo;
    
    @Transactional
    public Book createBook(Integer isbn, String title, Integer year, Author author, Editorial editorial, String frontImage, Integer copies) throws Exception{
        
        validation(isbn, title, year, author, editorial, frontImage, copies);
        
        Book book = new Book();
        
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setYear(year);
        book.setAuthor(author);
        book.setEditorial(editorial);
        book.setFrontImage(frontImage);
        book.setCopies(copies);
        book.setRemainingCopies(copies);
        book.setBorrowedCopies(0);
        book.setAvailable(true);
        
        return bookRepo.save(book);
    }
    
    public void validation(Integer isbn, String title, Integer year, Author author, Editorial editorial, String frontImage, Integer copies) throws Exception{
        
       if (title.isEmpty()){
           throw new Exception ();
       }
        
    }
    
    public void validation2(Integer isbn, String title, Integer year, Author author, Editorial editorial, String frontImage, Integer copies, Integer remainingCopies, Integer borrowedCopies, Boolean avaible) throws Exception{
    
     validation(isbn, title, year, author, editorial, frontImage, copies);
     
     if (remainingCopies > copies){
         throw new Exception();
     }
    }
        
        
    public List findAllBooks(){
        List<Book> bookList = bookRepo.findAll();
        
        return bookList;
    }
    
    public Book findBookByTitle(String title){
        
        Book book = bookRepo.findBookByTitle(title);
        return book;
    }
    
    @Transactional
    public Book setBook(Book book, Integer isbn, String title, Integer year, Author author, Editorial editorial, String frontImage, Integer copies, Integer remainingCopies, Integer borrowedCopies, Boolean avaible) throws Exception{
        
        validation2 (isbn, title, year, author, editorial, frontImage, copies, remainingCopies, borrowedCopies, avaible);
        
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setYear(year);
        book.setAuthor(author);
        book.setEditorial(editorial);
        book.setFrontImage(frontImage);
        book.setCopies(copies);
        book.setRemainingCopies(remainingCopies);
        book.setBorrowedCopies(borrowedCopies);
        book.setAvailable(avaible);
        
        return bookRepo.save(book);
    }
            
}
