package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
