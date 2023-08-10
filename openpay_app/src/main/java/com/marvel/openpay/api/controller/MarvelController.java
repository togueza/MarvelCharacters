package com.marvel.openpay.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.marvel.openpay.api.model.MarvelTable;
import com.marvel.openpay.api.repository.MarvelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.bezkoder.spring.jpa.h2.model.Tutorial;
//import com.bezkoder.spring.jpa.h2.repository.TutorialRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/marvel")
public class MarvelController {

    @Autowired
    MarvelRepository marvelRepository;

    @GetMapping("/v1/public/characters")
    public ResponseEntity<List<MarvelTable>> getAllCharacters(@RequestParam(required = false) String name) {
        try {
            List<MarvelTable> characters = new ArrayList<MarvelTable>();

            if (name == null)
                marvelRepository.findAll().forEach(characters::add);
            else
                marvelRepository.findByTitleContainingIgnoreCase(String.valueOf(characters)).forEach(characters::add);

            if (characters.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(characters, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/public/characters/{characterId}")
    public ResponseEntity<MarvelTable> getTutorialById(@PathVariable("characterId") long id) {
        Optional<MarvelTable> characterData = marvelRepository.findById(id);

        if (characterData.isPresent()) {
            return new ResponseEntity<>(characterData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    @PostMapping("/tutorials")
    public ResponseEntity<MarvelTable> createTutorial(@RequestBody MarvelTable tutorial) {
        try {
            MarvelTable _tutorial = marvelRepository.save(new MarvelTable(tutorial.getTitle(), tutorial.getDescription(), false));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<MarvelTable> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        Optional<MarvelTable> tutorialData = marvelRepository.findById(id);

        if (tutorialData.isPresent()) {
            MarvelTable _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            tutorialRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<MarvelTable>> findByPublished() {
        try {
            List<MarvelTable> tutorials = tutorialRepository.findByPublished(true);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
}
