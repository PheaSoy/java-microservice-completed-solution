package org.soyphea.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/static-message")
    public ResponseEntity<?> booksFallback(){
        return ResponseEntity.ok("ok fall back.");
    }
}