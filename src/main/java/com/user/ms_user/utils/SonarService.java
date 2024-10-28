package com.user.ms_user.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SonarService {

    @Value("${spring.sonar.url}")
    private String sonarUrl;
    @Value("${spring.sonar.token}")
    private String sonarToken;
    @Value("${spring.sonar.organization}")
    private String organization;
    @Value("${spring.sonar.projectkey}")
    private String projectKey;

    public String getCoverageData() {

        String url = String.format("%s/api/measures/component?component=%s&metricKeys=coverage", sonarUrl, projectKey);

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(sonarToken, "");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {

            return response.getBody();
        } else {
            throw new RuntimeException("Não foi possivel recuperar os dados do sonar");
        }

    }

}
