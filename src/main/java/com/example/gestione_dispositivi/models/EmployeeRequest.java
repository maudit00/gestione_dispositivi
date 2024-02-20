package com.example.gestione_dispositivi.models;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
/**
 * EmployeeRequest
 */
public class EmployeeRequest {

  private int id;

  @NotBlank(message = "Nome obbligatorio")
  private String nome;
  @NotBlank(message = "Cognome obbligatorio")
  private String cognome;
  @NotBlank(message = "Cognome obbligatorio")
  private String username;
  @NotBlank(message = "Cognome obbligatorio")
  private String password;
  @Email(message = "Inserire un'email valida")
  private String email;
}
