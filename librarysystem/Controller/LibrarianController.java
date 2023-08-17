package com.example.librarysystem.Controller;

import com.example.librarysystem.API.ApiResponse;
import com.example.librarysystem.Model.Librarian;
import com.example.librarysystem.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/librarian/")
public class LibrarianController {

    private final LibrarianService librarianService;


    @GetMapping("get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(librarianService.getALl());
    }


    @PostMapping("add")
    public ResponseEntity addLibrarian(@RequestBody @Valid Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body( new ApiResponse("Librarian added"));
    }


    @PutMapping("update/{id}")
    public ResponseEntity updateLibrarian(@PathVariable Integer id, @RequestBody @Valid Librarian librarian){
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(200).body( new ApiResponse("Librarian updated"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body( new ApiResponse("Librarian deleted"));
    }


    @GetMapping("get-by-id/{id}")
    public ResponseEntity getLibrarianById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(librarianService.getLibrarianById(id));
    }

    @GetMapping("check-login/{username}/{password}")
    public ResponseEntity checkLogin(@PathVariable String username, @PathVariable String password){
        return ResponseEntity.status(200).body(librarianService.checkLogin(username, password));
    }

    @GetMapping("get-by-email/{email}")
    public ResponseEntity getLibrarianByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(librarianService.getLibrarianAccountByEmail(email));
    }
}
