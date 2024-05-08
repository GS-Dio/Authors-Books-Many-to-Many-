package com.adi.Authors.Books.Many.to.Many.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    private Long authorId;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_genres",
            joinColumns = @JoinColumn(name = "author_id",referencedColumnName = "authorId"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "genreId"))
    private Set<Genre> genres = new HashSet<>();
}
