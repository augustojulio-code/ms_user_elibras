package com.user.ms_user.adapters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.ms_user.utils.SonarService;

@RestController
@RequestMapping("api/sonarcloud")
public class SonarCloudController {

    @Autowired
    private SonarService sonarCloudService;

    @GetMapping("/coverage")
    public ResponseEntity<String> coverageCode() {

        String coverageData = sonarCloudService.getCoverageData();

        return ResponseEntity.ok(coverageData);
    }

}
