package com.staffsterr2000.integrationapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankApplication {

    private List<Applicant> applicants;

    private Integer loanAmount;

    private Integer termYears;

    private Integer applicationId;

}
