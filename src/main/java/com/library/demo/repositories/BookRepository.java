
package com.library.demo.repositories;

import com.library.demo.entities.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, String>{
    
    @Query("SELECT b from Book b WHERE b.id = id ")
    public Book findBookById(String id);
    
    @Query("SELECT b from Book b WHERE b.title = title ")
    public Book findBookByTitle(String title);
    
//    @Query("SELECT *")
//    public List<Book> findAllBooks();
//    
    @Query("SELECT b from Book b WHERE b.available = true ")
    public List<Book> findBooksAvailables();
    
}
