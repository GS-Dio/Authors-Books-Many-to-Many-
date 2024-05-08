package com.adi.Authors.Books.Many.to.Many.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue
    private Long genreId;
    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Author> authors = new HashSet<>();
}
