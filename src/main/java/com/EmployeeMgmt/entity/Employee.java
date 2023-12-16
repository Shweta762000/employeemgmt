package com.EmployeeMgmt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="emp_name")
    @NotBlank(message = "name is mandatory ")
    private String name;
    @Column(name="emp_email",unique = true)
    @NotBlank(message = "email is mandatory")
    private String email;
    @Column(name="emp_designation")
    private String designation;
    @Column(name="emp_joinigdate")
    private Date joinig_date;


}
