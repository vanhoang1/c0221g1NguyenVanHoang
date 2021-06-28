package com.borrow_book.model.entity.dto;

import com.borrow_book.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCardDto {

    private Integer id;
    private LocalDate borrowedDate;
    private LocalDate returnedDate;
    private String status;
    private Book book;

}
