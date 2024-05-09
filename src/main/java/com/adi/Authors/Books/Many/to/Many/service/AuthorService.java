package com.adi.Authors.Books.Many.to.Many.service;

import com.adi.Authors.Books.Many.to.Many.domain.Author;
import com.adi.Authors.Books.Many.to.Many.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public Author save(Author author){
        return authorRepository.save(author);
    }

    public Author update(Long id, Author updateAuthor){
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isPresent()){
            Author newAuthor = optionalAuthor.get();

            newAuthor.setName(updateAuthor.getName());

            return authorRepository.save(newAuthor);
        }else {
            log.warn("Author with " + id + " id not found!!");
            throw new IllegalArgumentException("Author with id " + id + " not found");
        }
    }

    public Author findById(Long id){
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isPresent()){
            return optionalAuthor.get();
        }else
            log.warn("Author with " + id + " id not found!!");
        return null;
    }

    public List<Author> findAll(){
        List<Author> authors = new LinkedList<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    public void delete(Long id){
        authorRepository.deleteById(id);
    }
}
