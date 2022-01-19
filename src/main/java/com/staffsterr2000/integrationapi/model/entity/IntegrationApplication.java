package com.staffsterr2000.integrationapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IntegrationApplication {

    private IntegrationApplicant applicant;

    private IntegrationApplicant coApplicant;

    private Integer loanAmount;

    private Integer termMonths;

    private Integer id;

}
