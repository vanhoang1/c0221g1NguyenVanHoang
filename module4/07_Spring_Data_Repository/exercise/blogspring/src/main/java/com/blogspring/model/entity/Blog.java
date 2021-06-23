package com.blogspring.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id ;
   private String author;
   private String title;
   private int status;
   private String content;
   @Column(name = "date_created")
   private LocalDate createDate;
   @ManyToOne
   @JoinColumn(name = "category_id")
   @EqualsAndHashCode.Exclude
   @ToString.Exclude
   private Category category;
}
