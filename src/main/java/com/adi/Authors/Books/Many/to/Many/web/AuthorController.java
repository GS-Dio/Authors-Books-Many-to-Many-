package com.adi.Authors.Books.Many.to.Many.web;

import com.adi.Authors.Books.Many.to.Many.domain.Author;
import com.adi.Authors.Books.Many.to.Many.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public Author save(@RequestBody Author author){
        return authorService.save(author);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable Long id,@RequestBody Author author){
        return authorService.update(id,author);
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id){
        return authorService.findById(id);
    }

    @GetMapping
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        authorService.delete(id);
    }
}
