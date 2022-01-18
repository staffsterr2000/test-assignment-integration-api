package com.staffsterr2000.integrationapi.controller;

import com.staffsterr2000.integrationapi.model.entity.BankApplication;
import com.staffsterr2000.integrationapi.model.entity.IntegrationApplication;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/applications")
public class ApplicationController {

    // TODO: security
    @PostMapping
    public Mono<String> save(@RequestBody IntegrationApplication integrationApplication) {
        String username = "admin";
        String password = "password";
        WebClient client = WebClient.builder().filter(ExchangeFilterFunctions
                .basicAuthentication(username, password)).build();

        // TODO: convert applications fully
        BankApplication bankApplication = BankApplication.builder()
                .loanAmount(integrationApplication.getLoanAmount())
                .applicationId(integrationApplication.getId())
                .applicants(List.of()).build();

        return client.post()
                .uri("http://localhost:8082/applications")
                .body(Mono.just(bankApplication), BankApplication.class)
                .retrieve()
                // TODO: handle bad_request
//                .onStatus(HttpStatus.BAD_REQUEST::equals,
//                        response -> response.bodyToMono(String.class).map(RuntimeException::new))
                .bodyToMono(String.class);

    }

}
