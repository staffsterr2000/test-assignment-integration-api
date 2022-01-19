package com.staffsterr2000.integrationapi.controller;

import com.staffsterr2000.integrationapi.model.entity.IntegrationApplication;
import com.staffsterr2000.integrationapi.service.ApplicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/applications")
@Slf4j
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> save(@RequestBody IntegrationApplication integrationApplication, Authentication auth) {
        log.info("-------------------------");
        log.info("Authenticated as: " + auth.getName());
        String successResponse = applicationService.save(integrationApplication);
        log.info("Response: " + successResponse);

        return ResponseEntity.ok(successResponse);
    }

}
