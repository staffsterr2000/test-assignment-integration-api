package com.staffsterr2000.integrationapi.converter;

import com.staffsterr2000.integrationapi.model.entity.BankApplicant;
import com.staffsterr2000.integrationapi.model.entity.BankApplication;
import com.staffsterr2000.integrationapi.model.entity.IntegrationApplication;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
@Slf4j
@SuppressWarnings("ConstantConditions")
public class ApplicationConverter implements Converter<IntegrationApplication, BankApplication> {

    private final ApplicantConverter applicantConverter;

    @Override
    public BankApplication convert(IntegrationApplication source) {
        Integer termYears = Objects.isNull(source.getTermMonths()) ? null : source.getTermMonths() / 12;
        List<BankApplicant> applicants = List.of(
                applicantConverter.convert(source.getApplicant()),
                applicantConverter.convert(source.getCoApplicant()));

        BankApplication destination = BankApplication.builder()
                .applicationId(source.getId())
                .loanAmount(source.getLoanAmount())
                .termYears(termYears)
                .applicants(applicants).build();

        log.info("Application conversion successful:");
        log.info("\t" + source);
        log.info("\t" + destination);

        return destination;
    }
}
