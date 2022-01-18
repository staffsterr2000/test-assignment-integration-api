package com.staffsterr2000.integrationapi.model.entity;

import com.staffsterr2000.integrationapi.model.enumeration.EmploymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Applicant {

    private String firstName;

    private String lastName;

    private String email;

    private EmploymentStatus employmentStatus;

    private LocalDate employedSince;

    private Integer yearlyIncome;

    private Address address;

}
