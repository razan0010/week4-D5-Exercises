package com.example.librarysystem.Service;

import com.example.librarysystem.API.ApiException;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getALl() {
        return bookRepository.findAll();
    }


    public void addBook(Book book){
        bookRepository.save(book);
    }


    public void updateBook(Integer id , Book book){
        Book book1 = bookRepository.findBookById(id);

        if (book1 == null){
            throw new ApiException("Id not found");
        }
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setISBN(book.getISBN());
        book1.setCategory(book.getCategory());
        book1.setNumberOfPages(book.getNumberOfPages());

        bookRepository.save(book1);
    }


    public void deleteBook(Integer id){
        Book book1 = bookRepository.findBookById(id);

        if (book1 == null){
            throw new ApiException("Id not found");
        }

        bookRepository.delete(book1);
    }



//      Get books by Category
    public List<Book> getBookByCategory(String category){
        List<Book> book = bookRepository.findBookByCategory(category);

        if (book == null){
            throw new ApiException("Category not found");
        }

        return book;
    }


//    Get books hava pages more than 300
    public List<Book> getBooksLargePages(){
        List<Book> book = bookRepository.getBooksLargePages();

        if (book == null){
            throw new ApiException("Author not found");
        }
        return book;
    }


//      Get books by Author
    public List<Book> getBookByAuthor(String author){
        List<Book> book = bookRepository.findBookByAuthor(author);

        if(book == null){
            throw new ApiException("Author not found");
        }

        return book;
    }


//    search for book by title
    public Book getBookByTitle(String title){
        Book book = bookRepository.findBookByTitle(title);

        if(book == null){
            throw new ApiException("Title not found");
        }

        return book;
    }



}
