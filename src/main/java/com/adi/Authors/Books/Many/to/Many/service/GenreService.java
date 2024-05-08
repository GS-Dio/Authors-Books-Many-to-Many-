package com.adi.Authors.Books.Many.to.Many.service;

import com.adi.Authors.Books.Many.to.Many.domain.Author;
import com.adi.Authors.Books.Many.to.Many.domain.Genre;
import com.adi.Authors.Books.Many.to.Many.repository.GenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GenreService {
    @Autowired
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre save(Genre genre){
        return genreRepository.save(genre);
    }

    public Genre update(Long id,Genre updateGenre){
        Optional<Genre> optionalGenre = genreRepository.findById(id);

        if (optionalGenre.isPresent()){
            Genre newGenre = optionalGenre.get();

            newGenre.setName(updateGenre.getName());

            return newGenre;
        }else
            log.warn("Genre with " + id + " id not found!!");

        return null;
    }

    public Genre findById(Long id){
        Optional<Genre> optionalGenre = genreRepository.findById(id);

        if (optionalGenre.isPresent()){
            return optionalGenre.get();
        }else
            log.warn("Genre with " + id + " id not found!!");
        return null;
    }

    public List<Genre> findAll(){
        List<Genre> genres = new LinkedList<>();
        genreRepository.findAll().forEach(genres::add);
        return genres;
    }

    public void delete(Long id){
        genreRepository.deleteById(id);
    }
}


