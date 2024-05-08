package com.adi.Authors.Books.Many.to.Many.repository;

import com.adi.Authors.Books.Many.to.Many.domain.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
