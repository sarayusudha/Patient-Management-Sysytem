package com.patient.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String Name;
    private String Gender;
    private Long Age;
    private Long Phno;
    private String Diagnosedwith;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Long getAge() {
		return Age;
	}
	public void setAge(Long age) {
		Age = age;
	}
	public Long getPhno() {
		return Phno;
	}
	public void setPhno(Long phno) {
		Phno = phno;
	}
	public String getDiagnosedwith() {
		return Diagnosedwith;
	}
	public void setDiagnosedwith(String diagnosedwith) {
		Diagnosedwith = diagnosedwith;
	}
	
    
}
