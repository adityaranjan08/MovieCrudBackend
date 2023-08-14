package com.niit.controller;

import com.niit.entity.Movie;
import com.niit.entity.User;
import com.niit.repo.MovieRepository;
import com.niit.service.MovieServiceImpl;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController

@RequestMapping("/api/v2/")   //maps http requests to the handler methods
public class MovieRestController {
    @Autowired
    MovieServiceImpl movieServiceImpl;
    MovieRepository movieRepository;

    /**
     * Register a new user
     * @param user, User which we want to register to MovieApplication
     * @return Response entity containing registered user entity and http status code.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){                               //HttpEntity that will return
        return new ResponseEntity<>(movieServiceImpl.register(user), HttpStatus.CREATED);   //value,HttpStatus
    }

    /**
     * Add favourite movie for a user
     * @param movie Add this movie as favourite to a particular user
     * @param email Email of the user which will be used as key.
     * @return Response entity containing movie entity and http status code.
     */
    @PostMapping("/user/{email}/movie")
    public ResponseEntity<?> saveFavouriteMovie(@RequestBody Movie movie, @PathVariable String email){
        return new ResponseEntity<>(movieServiceImpl.saveUserMovieToList(movie, email), HttpStatus.OK);
    }

    /**
     * Update movie of a user by movieId
     * @param email Email of the user which will be used as key.
     * @param movieId Id of that movie which will be updated
     * @param movie Updated movie entity.
     * @return Response entity containing updated movie entity and http status code.
     */
    @PutMapping("/user/{email}/{movieId}")          //{Put}->if value present then it will update , and if not saves new entry
    public ResponseEntity<?> updateMovieDesc(@PathVariable String email,@PathVariable int movieId,@RequestBody Movie movie) {
        return new ResponseEntity<>(movieServiceImpl.updateMovieDetails(email,movie,movieId),HttpStatus.OK);
    }

    /**
     * Delete a movie of a user by movieId
     * @param email Email of the user which will be used as key.
     * @param movieId Id of that movie which will be updated
     * @return Response entity containing deleted movie entity and http status code.
     */
    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> deleteMovieFromList(@PathVariable String email, @RequestParam int movieId) {
        return new ResponseEntity<>(movieServiceImpl.deleteUserMovieFromList(email,movieId),HttpStatus.OK);
    }

    /**
     * Get all movies for a particular movie
     * @param email Email of the user which will be used as key.
     * @return Response entity containing all movies for that user and http status code.
     */
    @GetMapping("/user/{email}/")
    public ResponseEntity<?> getAllUserMovies(@PathVariable String email) {
        return new ResponseEntity<>(movieServiceImpl.getAllUserMovies(email),HttpStatus.OK);
    }






}
