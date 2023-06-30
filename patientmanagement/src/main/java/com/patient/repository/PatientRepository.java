package com.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long>{

}
