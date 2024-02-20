package com.example.gestione_dispositivi.services;

import java.io.IOException;

import com.example.gestione_dispositivi.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gestione_dispositivi.exceptions.NotFoundException;
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
  @Autowired
  private PasswordEncoder encoder;

  @Autowired
  private JavaMailSenderImpl javaMailSenderImpl;

  public Page<Employees> getAll(Pageable pageable) {
    return employeesRepository.findAll(pageable);
  }

  public Employees getById(int id) {
    return employeesRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Employee with id=" + id + " not found!"));
  }

  public Employees save(EmployeeRequest employeeRequest) {

    Employees e = new Employees();
    e.setNome(employeeRequest.getNome());
    e.setCognome(employeeRequest.getCognome());
    e.setEmail(employeeRequest.getEmail());
    e.setUsername(employeeRequest.getUsername());
    e.setRole(Role.USER);
    e.setPassword(encoder.encode(employeeRequest.getPassword()));
    sendMail(e.getEmail());

    return employeesRepository.save(e);
  }

  public Employees update(int id, EmployeeRequest employeeRequest) {
    Employees e = getById(id);

    e.setNome(employeeRequest.getNome());
    e.setCognome(employeeRequest.getCognome());
    e.setUsername(employeeRequest.getUsername());
    e.setPassword(encoder.encode(employeeRequest.getPassword()));
    e.setEmail(employeeRequest.getEmail());

    return employeesRepository.save(e);
  }

  public void deleteEmployee(int id) {
    Employees e = getById(id);
    employeesRepository.delete(e);
  }

  private void sendMail(String email) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email);
    message.setSubject("Employee Registration Successfull");
    message.setText("Congrats on registering to the Factory Portal");
    javaMailSenderImpl.send(message);
  }

  public Employees uploadAvatar(int id, String url) {
    Employees e = getById(id);
    e.setAvatar(url);
    return employeesRepository.save(e);
  }

  public Employees getByUsername(String username){
    return employeesRepository.findByUsername(username).orElseThrow(()-> new NotFoundException("Username non trovato"));
  }

}
