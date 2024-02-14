package com.springrestapi.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


@Component
public class CustomInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> customDetails = new HashMap<>();
        customDetails.put("Application Name", "Simple using rest api");
        customDetails.put("version", "1.0.0");
        customDetails.put("Application Owner", "Washim Arshad");
        customDetails.put("email", "Washim63@gmail.com");
        LocalDateTime deploymentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        customDetails.put("deploymentTime", deploymentTime.format(formatter));
        customDetails.put("environment", "Development");

        Map<String, Object> endpoints = new HashMap<>();
        endpoints.put("health", "http://localhost:8080/admin/healthCheck");
        endpoints.put("info", "http://localhost:8080/admin/applicationInfo");
        endpoints.put("metrics", "http://localhost:8080/actuator/metrics");
        customDetails.put("endpoints", endpoints);

        builder.withDetail("customInfo", customDetails).build();
    }
}
