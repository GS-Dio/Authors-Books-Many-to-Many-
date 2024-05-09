package com.adi.Authors.Books.Many.to.Many.repository;

import com.adi.Authors.Books.Many.to.Many.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
