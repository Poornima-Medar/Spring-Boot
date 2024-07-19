package com.springboot.Assignments.weekTwoAssignment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.Assignments.weekTwoAssignment.Annotations.PasswordValidation;
import com.springboot.Assignments.weekTwoAssignment.Annotations.PrimeNumberValidation;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    @Positive(message = "Id value must be positive number")
    @NotNull(message = "Id should be null")
    @PrimeNumberValidation(message = "Id should be Prime number")
    private Long id;

    @NotBlank(message = "name should not be null anb blank")
    private String name;

    //@Null
    private String description;

    @PastOrPresent
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @AssertTrue
    @JsonProperty("isActive")
    private boolean isActive;

    @URL
    private String website;

    @Positive
    @DecimalMin(value = "9999.99")
    @DecimalMax(value = "100000000.99")
    private Double budget;

    @Email
    private String email;

    @CreditCardNumber
    private String creditCardNumber;

    @PasswordValidation
    private String password;

}
