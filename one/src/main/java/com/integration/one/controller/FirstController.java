package com.integration.one.controller;

import com.integration.one.dto.FirstDto;
import com.integration.one.service.FirstEntitiesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Maciej Lesniak
 */
@RestController
@RequestMapping("/first")
public class FirstController {

    private FirstEntitiesService service;

    public FirstController(FirstEntitiesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FirstDto> add(@RequestBody FirstDto input) {
        service.save(input);
        return ResponseEntity.ok(null);
    }

}
