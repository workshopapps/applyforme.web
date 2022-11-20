package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.service.ApplicationSubmissionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
public class ApplicationSubmissionsController {

    private final ApplicationSubmissionsService applicationSubmissionsService;

    @GetMapping("/application-submissions")
    public ResponseEntity<Collection<Submission>> getAll() {
//       new ResponseEntity<>(applicationSubmissionsService.getAllApplicationSubmissions(), HttpStatus.OK);
        return ResponseEntity.ok(applicationSubmissionsService.getAllApplicationSubmissions());
    }
}
