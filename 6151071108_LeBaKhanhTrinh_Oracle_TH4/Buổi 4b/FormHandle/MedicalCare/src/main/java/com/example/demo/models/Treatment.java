package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TREATMENTS")
public class Treatment {
	@Id
	@Column(name = "TREATMENTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer treatmenntID;
	
	@Column(name = "DOCTORID")
	private Integer doctorID;
	
	@Column(name = "PATIENTID")
	private Integer patientID;
	
	@Column(name = "TYPEOFTREATMENT")
	private String typeOfTreatment;

	public Integer getTreatmenntID() {
		return treatmenntID;
	}

	public void setTreatmenntID(Integer treatmenntID) {
		this.treatmenntID = treatmenntID;
	}

	public Integer getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(Integer doctorID) {
		this.doctorID = doctorID;
	}

	public Integer getPatientID() {
		return patientID;
	}

	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
	}

	public String getTypeOfTreatment() {
		return typeOfTreatment;
	}

	public void setTypeOfTreatment(String typeOfTreatment) {
		this.typeOfTreatment = typeOfTreatment;
	}

	
}