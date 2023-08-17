package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "Username should be not empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;

    @NotEmpty(message = "Password should be not empty")
    @Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d\\s]{1,}$" , message = "Password have characters and digits")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message = "Email must be not empty!")
    @Email(message = "Email must be a valid")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

}
