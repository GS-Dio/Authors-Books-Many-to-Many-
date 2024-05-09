package com.adi.Authors.Books.Many.to.Many.repository;

import com.adi.Authors.Books.Many.to.Many.domain.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
}
