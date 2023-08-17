package com.example.librarysystem.Repository;

import com.example.librarysystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookById(Integer id);
    List<Book> findBookByAuthor(String author);
    Book findBookByTitle(String title);
    List<Book> findBookByCategory(String category);
     @Query("select b from Book b where b.numberOfPages >= 300")
     List<Book> getBooksLargePages();


}
