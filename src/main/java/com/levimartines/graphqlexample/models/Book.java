package com.levimartines.graphqlexample.models;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "books")
@Where(clause = "is_active = true")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String isbn = UUID.randomUUID().toString();
    private String title;
    private String subject;
    @ManyToOne
    private Author author;
    private LocalDate createdAt = LocalDate.now();
    @Column(name = "is_active")
    private boolean active = true;
}
