package com.example.gestione_dispositivi.controllers;

import com.example.gestione_dispositivi.exceptions.BadRequestException;
import com.example.gestione_dispositivi.exceptions.LoginException;
import com.example.gestione_dispositivi.models.EmployeeRequest;
import com.example.gestione_dispositivi.models.Employees;
import com.example.gestione_dispositivi.models.LoginRequest;
import com.example.gestione_dispositivi.security.JwtTools;
import com.example.gestione_dispositivi.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private JwtTools jwtTools;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/auth/register")
    public Employees register(@RequestBody @Validated EmployeeRequest employeeRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        return employeesService.save(employeeRequest);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated LoginRequest loginRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        Employees employee = employeesService.getByUsername(loginRequest.getUsername());
        if(encoder.matches(loginRequest.getPassword(), employee.getPassword())){
            return jwtTools.createToken(employee);
        } else {
         throw new LoginException("User/password errati");
        }
    }  @PostMapping("/auth/login")
    public String login(@RequestBody @Validated LoginRequest loginRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        Employees employees = employeesService.getByUsername(loginRequest.getUsername());

        if(encoder.matches(loginRequest.getPassword(), employees.getPassword())){
            return jwtTools.createToken(employees);
        }
        else{
            throw new LoginFaultException("username/password errate");
        }

    }
}
