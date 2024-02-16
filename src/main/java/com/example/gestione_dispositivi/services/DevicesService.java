package com.example.gestione_dispositivi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.gestione_dispositivi.repositories.DevicesRepository;

@Service
/**
 * DevicesService
 */
public class DevicesService {

  @Autowired
  private DevicesRepository devicesRepository;

  public Page<Devices> getAll(Pageable pageable) {

  }
}
