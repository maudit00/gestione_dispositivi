package com.example.gestione_dispositivi.models;

import com.example.gestione_dispositivi.enums.DeviceStatus;
import com.example.gestione_dispositivi.enums.DeviceType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
/**
 * Devices
 */
public class Devices {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id")
  @SequenceGenerator(name = "employee_id", allocationSize = 1, initialValue = 1)
  private int id;

  private String nome;
  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employees employee;

  @Enumerated(EnumType.STRING)
  private DeviceType deviceType;

  @Enumerated(EnumType.STRING)
  private DeviceStatus deviceStatus;
}
