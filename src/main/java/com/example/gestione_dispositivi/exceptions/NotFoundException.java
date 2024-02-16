package com.example.gestione_dispositivi.exceptions;

import org.aspectj.weaver.ast.Not;

/**
 * NotFoundException
 */
public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }

}
