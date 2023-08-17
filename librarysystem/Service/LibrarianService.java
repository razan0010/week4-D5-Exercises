package com.example.librarysystem.Service;

import com.example.librarysystem.API.ApiException;
import com.example.librarysystem.Model.Librarian;
import com.example.librarysystem.Repository.LibrarianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public List<Librarian> getALl() {
        return librarianRepository.findAll();
    }


    public void addLibrarian(Librarian librarian){
        librarianRepository.save(librarian);
    }


    public void updateLibrarian(Integer id , Librarian librarian){
        Librarian librarian1 = librarianRepository.getLibrarianById(id);

        if (librarian1 == null){
            throw new ApiException("Id not found");
        }

        librarian1.setName(librarian.getName());
        librarian1.setUsername(librarian.getUsername());
        librarian1.setEmail(librarian.getEmail());
        librarian1.setEmail(librarian.getEmail());

        librarianRepository.save(librarian1);
    }


    public void deleteLibrarian(Integer id){
        Librarian librarian1 = librarianRepository.getLibrarianById(id);

        if (librarian1 == null){
            throw new ApiException("Id not found");
        }

        librarianRepository.delete(librarian1);
    }

    public Librarian getLibrarianById(Integer id){
        Librarian librarian = librarianRepository.getLibrarianById(id);

        if (librarian == null){
            throw new ApiException("Id not found");
        }
        return librarian;
    }

    public String checkLogin(String username, String password){
        Librarian librarian = librarianRepository.getLibrarianByUsernameAndPassword(username, password);
        if (librarian == null){
            throw new ApiException("Username not found");
        }
        return "Librarian is login";
    }

    public Librarian getLibrarianAccountByEmail(String email){
        Librarian librarian = librarianRepository.getLibrarianAccountByEmail(email);

        if (librarian == null){
            throw new ApiException("Username not found");
        }

        return librarian;
    }
}
