package com.patient.exception;

public class PatientNotFoundException extends RuntimeException{
	 public PatientNotFoundException(Long id){
	        super("Could not found the patient with id "+ id);
	    }
}
