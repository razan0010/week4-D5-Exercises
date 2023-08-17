package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title should be not empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String title;

    @NotEmpty(message = "Author should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;

    @NotEmpty(message = "Category should be not empty")
    @Pattern(regexp ="\\b(academic|mystery|novel)\\b" , message = "Category must have to be in academic or mystery or novel ")
    @Column(columnDefinition = "varchar(20) not null check(category= 'academic' or category = 'mystery' or category = 'novel')")
    private String category;

    @NotNull(message = "ISBN should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer isbn;

    @NotNull(message = "Number of pages should be not empty")
    @Min(value =50 , message = "Number of pages should be more than 50 pages")
    @Column(columnDefinition = "int not null")
    private Integer numberOfPages;
}
