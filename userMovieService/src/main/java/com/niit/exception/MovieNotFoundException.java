package com.niit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * MovieNotFoundException which extends exception.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "movie with specified id not found")
public class MovieNotFoundException extends Exception {

}
