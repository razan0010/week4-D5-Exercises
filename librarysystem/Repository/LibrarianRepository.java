package com.example.librarysystem.Repository;

import com.example.librarysystem.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
    
    Librarian getLibrarianById(Integer id);
    Librarian getLibrarianByUsernameAndPassword(String username, String password);
    @Query("select l from Librarian l where l.email=?1")
    Librarian getLibrarianAccountByEmail(String email);
}
