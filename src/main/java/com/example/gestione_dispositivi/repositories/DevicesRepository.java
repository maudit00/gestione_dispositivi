package com.example.gestione_dispositivi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.gestione_dispositivi.models.Devices;

/**
 * DevicesRepository
 */
public interface DevicesRepository
    extends JpaRepository<Devices, Integer>, PagingAndSortingRepository<Devices, Integer> {

}
