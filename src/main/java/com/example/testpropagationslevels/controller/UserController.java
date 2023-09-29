package com.example.testpropagationslevels.controller;

import com.example.testpropagationslevels.service.MultiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private MultiService multiService;

    @PostMapping("/test-requires_new-propagation")
    public ResponseEntity<String> testReqNew() {
        multiService.testPropagation();
        return ResponseEntity.ok("Test completed");
    }

    @PostMapping("/test-required-propagation")
    public ResponseEntity<String> testReq() {
        multiService.testReqPropagation();
        return ResponseEntity.ok("Test completed");
    }


}
