package com.example.gestione_dispositivi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestione_dispositivi.models.DeviceRequest;
import com.example.gestione_dispositivi.models.Devices;
import com.example.gestione_dispositivi.services.DevicesService;

@RestController
@RequestMapping("/devices")

/**
 * DevicesController
 */
public class DevicesController {

  @Autowired
  private DevicesService devicesService;

  @GetMapping
  public Page<Devices> getAll(Pageable pageable) {
    return devicesService.getAll(pageable);
  }

  @GetMapping("/{id}")
  public Devices getAuthorById(@PathVariable int id) {
    return devicesService.getById(id);
  }

  @PostMapping
  public Devices saveAuthor(@RequestBody @Validated DeviceRequest deviceRequest) {
    return devicesService.save(deviceRequest);
  }

  @PutMapping("/{id}")
  public Devices updateAuthor(@PathVariable int id, @RequestBody @Validated DeviceRequest deviceRequest) {
    return devicesService.update(id, deviceRequest);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthor(@PathVariable int id) {
    devicesService.delete(id);
  }

  @PatchMapping("/{id}/assign")
  public Devices assignDevie(@PathVariable int id, @RequestParam("employee_id") int idE) {
    return devicesService.assign(id, idE);
  }
}
