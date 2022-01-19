package com.staffsterr2000.integrationapi.converter;

import com.staffsterr2000.integrationapi.model.entity.BankApplicant;
import com.staffsterr2000.integrationapi.model.entity.IntegrationApplicant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
@Slf4j
public class ApplicantConverter implements Converter<IntegrationApplicant, BankApplicant> {

    @Override
    public BankApplicant convert(IntegrationApplicant source) {
        String address = String.format("%s %s", source.getAddress().getStreet(), source.getAddress().getHouseNumber());
        Boolean isEmployed = Objects.isNull(source.getEmployedStatus()) ? null : source.getEmployedStatus().getIsEmployed();
        Integer monthlyIncome = Objects.isNull(source.getYearlyIncome()) ? null : source.getYearlyIncome() / 12;

        BankApplicant destination = BankApplicant.builder()
                .name(source.getFirstName())
                .surname(source.getLastName())
                .email(source.getEmail())
                .isEmployed(isEmployed)
                .employedSince(source.getEmployedSince())
                .monthlyIncome(monthlyIncome)
                .address(address).build();

        log.info("Applicant conversion successful:");
        log.info("\t" + source);
        log.info("\t" + destination);

        return destination;
    }
}
