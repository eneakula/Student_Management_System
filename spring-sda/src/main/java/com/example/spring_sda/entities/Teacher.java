package com.example.spring_sda.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Teacher {

    @Id
    private Long id;

    private String name;
    private String surname;
    private String subject;
}
