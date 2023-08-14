package com.niit.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * MovieDetails Entity
 */
@Setter
@Getter
@ToString
public class MovieDetails {
    String genre;
    String rating;
    String director;
    String description;


}
