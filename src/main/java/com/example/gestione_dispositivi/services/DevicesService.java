package com.example.gestione_dispositivi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.gestione_dispositivi.enums.DeviceStatus;
import com.example.gestione_dispositivi.exceptions.DeviceNotAvaiableException;
import com.example.gestione_dispositivi.exceptions.NotFoundException;
import com.example.gestione_dispositivi.models.DeviceRequest;
import com.example.gestione_dispositivi.models.Devices;
import com.example.gestione_dispositivi.models.Employees;
import com.example.gestione_dispositivi.repositories.DevicesRepository;
import com.example.gestione_dispositivi.repositories.EmployeesRepository;

@Service
/**
 * DevicesService
 */
public class DevicesService {

  @Autowired
  private DevicesRepository devicesRepository;
  @Autowired
  private EmployeesService employeesService;

  public Page<Devices> getAll(Pageable pageable) {
    return devicesRepository.findAll(pageable);
  }

  public Devices getById(int id) {
    return devicesRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Device with id=" + id + " not found!"));
  }

  public Devices save(DeviceRequest deviceRequest) {
    Devices d = new Devices();
    d.setName(deviceRequest.getName());
    d.setDeviceType(deviceRequest.getDeviceType());
    d.setDeviceStatus(deviceRequest.getDeviceStatus());
    return devicesRepository.save(d);
  }

  public Devices update(int id, DeviceRequest deviceRequest) {
    Devices d = getById(id);
    d.setName(deviceRequest.getName());
    d.setDeviceType(deviceRequest.getDeviceType());
    d.setDeviceStatus(deviceRequest.getDeviceStatus());
    return devicesRepository.save(d);
  }

  public void delete(int id) {
    Devices d = getById(id);
    devicesRepository.delete(d);
  }

  public Devices assign(int idDevice, int idEmployee) {
    Employees e = employeesService.getById(idEmployee);
    Devices d = getById(idDevice);
    if (d.getDeviceStatus() == DeviceStatus.BUSY || d.getDeviceStatus() == DeviceStatus.ON_MAINTENANCE) {
      throw new DeviceNotAvaiableException("Device Busy or in Maintenance");
    }
    d.setEmployee(e);
    d.setDeviceStatus(DeviceStatus.BUSY);
    return devicesRepository.save(d);
  }

}
