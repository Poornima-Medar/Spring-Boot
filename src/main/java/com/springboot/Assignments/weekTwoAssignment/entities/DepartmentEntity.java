package com.springboot.Assignments.weekTwoAssignment.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {

    @Id
    private Long id;

    private String name;

    private String description;

    private LocalDate createdDate;

    @JsonProperty("isActive")
    private boolean isActive;

    private String website;

    private Double budget;

    private String email;

    private String creditCardNumber;

    private String password;
}
