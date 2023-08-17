package com.example.librarysystem.Controller;

import com.example.librarysystem.API.ApiResponse;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book/")
public class BookController {

    private final BookService bookService;

    @GetMapping("get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(bookService.getALl());
    }


    @PostMapping("add")
    public ResponseEntity addBook(@RequestBody @Valid Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body( new ApiResponse("Book added"));
    }


    @PutMapping("update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @RequestBody @Valid Book book){
        bookService.updateBook(id,book);
        return ResponseEntity.status(200).body( new ApiResponse("Book updated"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body( new ApiResponse("Book deleted"));
    }


    @GetMapping("get-by-category/{category}")
    public ResponseEntity getBookByCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(bookService.getBookByCategory(category));
    }


    @GetMapping("get-large-pages")
    public ResponseEntity getBooksLargePages(){
        return ResponseEntity.status(200).body(bookService.getBooksLargePages());
    }

    @GetMapping("get-by-author/{author}")
    public ResponseEntity getBookByAuthor(@PathVariable String author){
        return ResponseEntity.status(200).body(bookService.getBookByAuthor(author));
    }

    @GetMapping("get-by-title/{title}")
    public ResponseEntity getBookByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(bookService.getBookByTitle(title));
    }

}
