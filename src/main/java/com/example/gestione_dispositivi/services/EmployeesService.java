package com.example.gestione_dispositivi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.gestione_dispositivi.models.EmployeeRequest;
import com.example.gestione_dispositivi.models.Employees;
import com.example.gestione_dispositivi.repositories.EmployeesRepository;

@Service
/**
 * EmployeesService
 */
public class EmployeesService {

  @Autowired
  private EmployeesRepository employeesRepository;

  public Page<Employees> getAll(Pageable pageable) {
    return employeesRepository.findAll(pageable);
  }

  public Employees getById(int id){
    return employeesRepository.findById(id)
    .orElseThrow(() -> new NotFoundException("Employee with id="+ id + " not found!");
  }

  public Employees save(EmployeeRequest employeeRequest){

    Employees e = new Employees( employeeRequest.getNome(), employeeRequest.getCognome(), employeeRequest.getEmail(),)
  }
}
