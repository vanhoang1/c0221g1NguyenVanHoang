package com.blogspring.model.entity;

import lombok.Data;

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
   private String topic;
   private String content;
   @Column(name = "date_created")
   private LocalDate createDate;
    public Blog() {
    }
}
