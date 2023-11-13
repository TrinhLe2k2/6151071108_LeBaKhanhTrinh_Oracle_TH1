package com.example.webrestapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="jobs")
@Entity
@Data
@NoArgsConstructor
public class Jobs {
        @Id
        @Column(name = "job_id")
        private String id;
        String job_title;
        double min_salary;
        double max_salary;
}
