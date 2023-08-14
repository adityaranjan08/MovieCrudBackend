package com.niit.service;

import com.niit.entity.Movie;
import com.niit.entity.User;

import java.util.List;

public interface UserMovieService {
    /**
     * Register a new user to the movie service
     * @param user User entity
     * @return register the user and return User entity
     */
    User register(User user);

    /**
     * Save new movie to movie list
     * @param movie Movie entity which will be added to the movie list for a user
     * @param email Email of the user which will be used as key
     * @return User entity
     */
    User saveUserMovieToList(Movie movie, String email);

    /**
     * Delete a movie by movie id
     * @param email Email id of the user
     * @param movieId Id of the movie which is going to be deleted
     * @return User entity
     */
    User deleteUserMovieFromList(String email,int movieId);

    /**
     * Get all the movies for a user
     * @param email email of the user
     * @return list of movie entity for that user
     */
    List<Movie> getAllUserMovies(String email);

    /**
     * Update movie details by movie id for a user
     * @param email email id of the user
     * @param movie Updated movie entity
     * @param movieId id of the movie which is going to be updated
     * @return User entity
     */
    User updateMovieDetails(String email,Movie movie,int movieId);
}
