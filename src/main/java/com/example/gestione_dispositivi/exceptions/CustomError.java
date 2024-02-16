package com.example.gestione_dispositivi.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
/**
 * CustomError
 */
public class CustomError {

  private String message;
  private LocalDateTime data;

  public CustomError(String message) {
    this.message = message;
    data = LocalDateTime.now();
  }

}
