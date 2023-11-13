package com.example.webrestapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="locations")
@Entity
@Data
@NoArgsConstructor
public class Locations {
    @Id
    @Column(name = "location_id")
    private int id;
    String street_address;
    String postal_code;
    String city;
    String state_province;
}
