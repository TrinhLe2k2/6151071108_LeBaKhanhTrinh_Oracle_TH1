package com.example.webrestapi.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="EMPLOYEES")
public class Employees {
    @Id
    @Column(name = "employee_id")
    private int id;
    @Column(name = "first_name")
    String first_name;
    @Column(name = "last_name")
    String last_name;
    @Column(name = "email")
    String email;
    @Column(name = "phone_number")
    String phone_number;
    @Column(name = "hire_date")
    Date hire_date;
    @Column(name = "salary")
    double salary;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="job_id",referencedColumnName = "job_id")
    private Jobs jobs;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="department_id",referencedColumnName = "department_id")
    private Department department;
}
