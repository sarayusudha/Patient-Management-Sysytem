package com.patient.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patient.exception.PatientNotFoundException;
import com.patient.model.Patient;
import com.patient.repository.PatientRepository;



@RestController
@CrossOrigin("http://localhost:3000")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	@PostMapping("/patient")
    Patient newPatient(@RequestBody Patient newPatient) {
		return patientRepository.save(newPatient);
	}

	
	@GetMapping("/patients")
	List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	@GetMapping("/patient/{id}")
	Patient getPatientById(@PathVariable Long id) {
		return patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
	}
	@PutMapping("/patient/{id}")
	Patient updatePatient(@RequestBody Patient newPatient, @PathVariable Long id) {
		return patientRepository.findById(id).map(patient -> {
			patient.setName(newPatient.getName());
			patient.setGender(newPatient.getGender());
			patient.setAge(newPatient.getAge());
			patient.setPhno(newPatient.getPhno());
			patient.setDiagnosedwith(newPatient.getDiagnosedwith());
			
			return patientRepository.save(patient);
		}).orElseThrow(() -> new PatientNotFoundException(id));
	}
	@DeleteMapping("/patient/{id}")
	String deletePatient(@PathVariable Long id) {
		if (!patientRepository.existsById(id)) {
			throw new PatientNotFoundException(id);
		}
		patientRepository.deleteById(id);
		return "Patient with id " + id + " has been deleted success.";
	}
}
