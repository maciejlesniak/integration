package com.integration.one.service;

import com.integration.one.domain.FirstEntity;
import com.integration.one.dto.FirstDto;
import com.integration.one.dto.SecondDto;
import com.integration.one.repository.FirstEntityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maciej Lesniak
 */
@Service
public class FirstEntitiesService {

    private static final Logger LOG = Logger.getLogger(FirstEntitiesService.class.getName());

    @Value("${second}")
    private String secondAddress;

    private FirstEntityRepository repository;
    private RestTemplate restTemplate;

    @Autowired
    public FirstEntitiesService(FirstEntityRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public void save(FirstDto dto) {
        FirstEntity domainObj = new FirstEntity(dto.getFirstName(), dto.getLastName());
        FirstEntity savedEntity = repository.save(domainObj);
        LOG.log(Level.INFO, savedEntity.getId().toString());

        ResponseEntity<Void> response = restTemplate.postForEntity(secondAddress,
                new SecondDto(savedEntity.getId(), dto.getScore()), Void.class);

        LOG.log(Level.INFO, response.getStatusCode().toString());
    }

}
