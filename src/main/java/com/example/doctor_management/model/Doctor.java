package com.example.doctor_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // it is an entity class representing table inside database
@Table(name = "doctor")// this will create table inside database if name is not given class name will be considered as table name
public class Doctor {

    @Id // it is the primary key of the table and have unqiue values
    @Column(name = "doctor_id")// it creates the column with the name specified
    @GeneratedValue(strategy = GenerationType.AUTO)// it automatically generates the id
    private int doctorId;

    @Column(name = "doctor_name", nullable = false)
    private String doctorName;//  nullable = false - we need to enter the field mandatorily

    @Column(name = "email", nullable = false, unique = true)
    private String email;// unique = true - this will not allow duplicate values

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "qualification", nullable = false)
    private String qualification;
}
