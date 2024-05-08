package com.adi.Authors.Books.Many.to.Many.web;

import com.adi.Authors.Books.Many.to.Many.domain.Genre;
import com.adi.Authors.Books.Many.to.Many.repository.GenreRepository;
import com.adi.Authors.Books.Many.to.Many.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public Genre save(@RequestBody Genre genre){
        return genreService.save(genre);
    }

    @PutMapping("/{id}")
    public Genre update(@PathVariable Long id, @RequestBody Genre genre){
        return genreService.update(id,genre);
    }

    @GetMapping("/{id}")
    public Genre findById(@PathVariable Long id){
        return genreService.findById(id);
    }

    @GetMapping
    public List<Genre> findAll(){
        return genreService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        genreService.delete(id);
    }
}
