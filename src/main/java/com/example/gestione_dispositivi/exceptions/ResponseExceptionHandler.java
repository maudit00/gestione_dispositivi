package com.example.gestione_dispositivi.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
/**
 * ResponseExceptionHandler
 */
public class ResponseExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public CustomError NotFoundExceptionHandler(NotFoundException e) {
    return new CustomError(e.getMessage());
  }

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CustomError badRequestException(BadRequestException e) {
    return new CustomError(e.getMessage());
  }

  @ExceptionHandler(UnauthorizedException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public CustomError UnauthorizedException(UnauthorizedException e) {
    return new CustomError(e.getMessage());
  }

  @ExceptionHandler(DeviceNotAvaiableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CustomError DeviceNotAvaiableException(DeviceNotAvaiableException e) {
    return new CustomError(e.getMessage());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CustomError ExceptionHandler(Exception e) {
    return new CustomError(e.getMessage());
  }

  @ExceptionHandler(IOException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CustomError IOExceptionHandler(Exception e) {
    return new CustomError(e.getMessage());
  }

}
