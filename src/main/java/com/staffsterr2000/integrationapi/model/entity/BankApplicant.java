package com.staffsterr2000.integrationapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankApplicant {

    private String name;

    private String surname;

    private String email;

    private Boolean isEmployed;

    private String employedSince;

    private Integer monthlyIncome;

    private String address;

}
