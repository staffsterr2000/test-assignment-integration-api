package com.staffsterr2000.integrationapi.service.impl;

import com.staffsterr2000.integrationapi.converter.ApplicationConverter;
import com.staffsterr2000.integrationapi.exception.UnsuccessfulOperationException;
import com.staffsterr2000.integrationapi.model.entity.BankApplication;
import com.staffsterr2000.integrationapi.model.entity.IntegrationApplication;
import com.staffsterr2000.integrationapi.service.ApplicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final static String USERNAME = "very_surprising_username_that_nobody_knows";
    private final static String PASSWORD = "very_strong_password_nobody_can_hack";

    private final ApplicationConverter applicationConverter;

    @Override
    @SuppressWarnings("ConstantConditions")
    public String save(IntegrationApplication integrationApplication) {
        BankApplication bankApplication = applicationConverter.convert(integrationApplication);
        String basicAuthHeader = "basic " + Base64Utils.encodeToString(
                (USERNAME + ":" + PASSWORD).getBytes(StandardCharsets.UTF_8));

        return WebClient.builder().build()
                .post().uri("http://localhost:8082/applications")
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, basicAuthHeader)
                .body(Mono.just(bankApplication), BankApplication.class)
                .retrieve()
                .onStatus(HttpStatus.BAD_REQUEST::equals,
                        response -> response.bodyToMono(String.class).map(UnsuccessfulOperationException::new))
                .bodyToMono(String.class).block();

    }

}
