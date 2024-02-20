package com.example.gestione_dispositivi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.gestione_dispositivi.models.Employees;

import java.util.Optional;

/**
 * EmployeesRepository
 */
public interface EmployeesRepository
    extends JpaRepository<Employees, Integer>, PagingAndSortingRepository<Employees, Integer> {

    Optional<Employees> findByUsername(String username);
}
