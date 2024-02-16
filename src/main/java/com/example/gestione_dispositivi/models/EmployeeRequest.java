package com.example.gestione_dispositivi.models;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
/**
 * EmployeeRequest
 */
public class EmployeeRequest {

  private int id;

  @NotNull(message = "Nome obbligatorio")
  @NotEmpty(message = "Nome non vuoto")
  private String nome;
  @NotNull(message = "Cognome obbligatorio")
  @NotEmpty(message = "Cognome non vuoto")
  private String cognome;
  @Email(message = "Inserire un'email valida")
  private String email;
  private String avatar;
  private List<Devices> devices;
}
