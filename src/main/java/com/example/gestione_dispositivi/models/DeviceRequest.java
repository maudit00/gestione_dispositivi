package com.example.gestione_dispositivi.models;

import com.example.gestione_dispositivi.enums.DeviceStatus;
import com.example.gestione_dispositivi.enums.DeviceType;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
/**
 * DeviceRequest
 */
public class DeviceRequest {

  @NotNull(message = "Employee can't be null!")
  private Employees employee;
  @NotNull(message = "Type can't be null!")
  private DeviceType deviceType;
  @NotNull(message = "Status can't be null!")
  private DeviceStatus deviceStatus;
}
