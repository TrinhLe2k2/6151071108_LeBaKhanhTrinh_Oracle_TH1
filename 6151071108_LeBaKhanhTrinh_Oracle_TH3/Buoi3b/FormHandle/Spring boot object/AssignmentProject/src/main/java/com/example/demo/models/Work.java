package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORKS")
public class Work {
	@Id
	@Column(name = "WORKID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer workID;
	
	@Column(name = "EMPNO")
	private Integer empNO;
	
	@Column(name = "PROJNO")
	private Integer projNO;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "DURATION")
	private String duration;

	public Integer getWorkID() {
		return workID;
	}

	public void setWorkID(Integer workID) {
		this.workID = workID;
	}

	public Integer getEmpNO() {
		return empNO;
	}

	public void setEmpNO(Integer empNO) {
		this.empNO = empNO;
	}

	public Integer getProjNO() {
		return projNO;
	}

	public void setProjNO(Integer projNO) {
		this.projNO = projNO;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}