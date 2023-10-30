package com.example.springbootsonarqube;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WebDeployController {

    @GetMapping("/deploy")
    public Map<String, Object> index() {
        return Map.of("message", "Web deploy ok", "date", LocalDateTime.now());
    }

}
