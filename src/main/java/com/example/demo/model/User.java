package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor              //klassi annotatsioonid
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;            //properties of the class
    private String name;
    private String email;


    }

