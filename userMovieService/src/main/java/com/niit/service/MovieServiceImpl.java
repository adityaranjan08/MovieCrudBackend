package com.niit.service;

import com.niit.entity.Movie;
import com.niit.entity.User;
import com.niit.exception.MovieNotFoundException;
import com.niit.proxy.UserProxy;
import com.niit.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieServiceImpl implements UserMovieService {

    private UserProxy userProxy;
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(UserProxy userProxy, MovieRepository movieRepository) {
        this.userProxy = userProxy;
        this.movieRepository = movieRepository;
    }


    @Override
    public User register(User user) {
        userProxy.save(user);
        return movieRepository.save(user);
    }

    @Override
    public User saveUserMovieToList(Movie movie, String email) {
        User user = movieRepository.findByEmail(email);
        if (user != null) {
            if (user.getMovieList() == null) {
                user.setMovieList(Arrays.asList(movie));
            } else {
                List favlist = user.getMovieList();
                favlist.add(movie);
                user.setMovieList(favlist);
            }
            return movieRepository.save(user);
        }
        return null;
    }

    @Override
    public User deleteUserMovieFromList(String email, int movieId) {
        User user = movieRepository.findByEmail(email);
        List<Movie> movieList = user.getMovieList();
        int index = 0;
        for (Movie m : movieList) {
            if (m.getMovieId() == movieId) {
                break;
            }
            index += 1;
        }
        user.getMovieList().remove(index);
        movieRepository.save(user);
        return user;
    }

    @Override
    public List<Movie> getAllUserMovies(String email) {
        User user = movieRepository.findByEmail(email);
        return user.getMovieList();
    }

    @Override
    public User updateMovieDetails(String email, Movie movie, int movieId) {
        User user = movieRepository.findByEmail(email);
        List<Movie> userDb = user.getMovieList();
        int index = 0;
        for (Movie m : userDb) {
            if (m.getMovieId() == movieId) {
                break;
            }
            index += 1;
        }
        userDb.set(index, movie);
        return movieRepository.save(user);
    }


}
