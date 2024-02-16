package com.example.gestione_dispositivi.controllers;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.example.gestione_dispositivi.models.EmployeeRequest;
import com.example.gestione_dispositivi.models.Employees;
import com.example.gestione_dispositivi.repositories.EmployeesRepository;
import com.example.gestione_dispositivi.services.EmployeesService;

@RestController
@RequestMapping("/employees")
/**
 * EmployeesController
 */
public class EmployeesController {

  @Autowired
  private EmployeesService employeesService;
  @Autowired
  private Cloudinary cloudinary;

  @GetMapping
  public Page<Employees> getAll(Pageable pageable) {
    return employeesService.getAll(pageable);
  }

  @GetMapping("/{id}")
  public Employees getById(@PathVariable int id) {
    return employeesService.getById(id);
  }

  @PostMapping
  public Employees save(@RequestBody EmployeeRequest employeeRequest) {
    return employeesService.save(employeeRequest);
  }

  @PutMapping("/{id}")
  public Employees update(@PathVariable int id, @RequestBody EmployeeRequest employeeRequest) {
    return employeesService.update(id, employeeRequest);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    employeesService.deleteEmployee(id);
  }

  @PatchMapping("/{id}/upload")
  public Employees uploadAvatar(@PathVariable int id, @RequestParam("upload") MultipartFile file) throws IOException {
    return employeesService.uploadAvatar(id,
        (String) cloudinary.uploader().upload(file.getBytes(), new HashMap()).get("url"));
  }

}
