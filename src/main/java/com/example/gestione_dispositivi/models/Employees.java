package com.example.gestione_dispositivi.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
/**
 * Employee
 */
public class Employees {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id")
  @SequenceGenerator(name = "employee_id", allocationSize = 1, initialValue = 1)
  private int id;

  private String nome;
  private String cognome;
  private String password;
  private String username;
  private String email;
  private String avatar;
  @OneToMany(mappedBy = "employee")
  @JsonIgnore
  private List<Devices> devices;

}
