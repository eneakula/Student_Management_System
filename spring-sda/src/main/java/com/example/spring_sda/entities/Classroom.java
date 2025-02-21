package com.example.spring_sda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Data
public class Classroom {

    @Id
    private Long id;

    @Column(name = "class_number")
    private Integer classNumber;
}
