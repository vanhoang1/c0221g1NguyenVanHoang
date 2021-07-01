package com.phonemanagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String producer;
    private String model;
    private double price;
}
