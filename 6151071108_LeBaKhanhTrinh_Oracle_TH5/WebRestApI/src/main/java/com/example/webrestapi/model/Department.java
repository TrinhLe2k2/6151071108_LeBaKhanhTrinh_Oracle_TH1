package com.example.webrestapi.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name ="departments")
@Entity
@Data
@NoArgsConstructor
public class Department {
    @Id
    @Column(name = "department_id")
    private int id;
    String department_name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="location_id",referencedColumnName = "location_id")
    private Locations locations;
}
