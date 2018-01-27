package com.integration.two.controller;

import com.integration.two.dto.SecondDto;
import com.integration.two.service.SecondEntitiesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Maciej Lesniak
 */
@RestController
@RequestMapping("/second")
public class SecondController {

    private SecondEntitiesService service;

    public SecondController(SecondEntitiesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SecondDto> add(@RequestBody SecondDto input) {
        service.save(input);
        return ResponseEntity.ok(null);
    }

}
