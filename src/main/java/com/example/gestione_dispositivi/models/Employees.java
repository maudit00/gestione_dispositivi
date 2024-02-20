package com.example.gestione_dispositivi.models;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Entity
/**
 * Employee
 */
public class Employees implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id")
  @SequenceGenerator(name = "employee_id", allocationSize = 1, initialValue = 1)
  private int id;

  private String nome;
  private String cognome;
  private String password;
  private String username;
  @Enumerated
  private Role role;
  private String email;
  private String avatar;
  @OneToMany(mappedBy = "employee")
  @JsonIgnore
  private List<Devices> devices;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
