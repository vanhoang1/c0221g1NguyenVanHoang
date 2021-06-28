package com.borrow_book.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {
    @Id
    private Integer id;
    private LocalDate borrowedDate;
    private LocalDate returnedDate;
    private String status;

    @ManyToOne
    @JoinColumn( name ="book_id")
    private Book book;
}
