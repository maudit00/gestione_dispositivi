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

  @NotNull(message = "Device's name can't be null!")
  private String name;
  @NotNull(message = "Type can't be null!")
  private DeviceType deviceType;
  @NotNull(message = "Status can't be null!")
  private DeviceStatus deviceStatus;
}
