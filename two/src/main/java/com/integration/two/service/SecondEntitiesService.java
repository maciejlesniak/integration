package com.integration.two.service;

import com.integration.two.domain.SecondEntity;
import com.integration.two.dto.SecondDto;
import com.integration.two.repository.SecondEntityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maciej Lesniak
 */
@Service
public class SecondEntitiesService {

    private static final Logger LOG = Logger.getLogger(SecondEntitiesService.class.getName());

    @Value("${second}")
    private String secondAddress;

    private SecondEntityRepository repository;
    private RestTemplate restTemplate;

    @Autowired
    public SecondEntitiesService(SecondEntityRepository repository,
                                 RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public void save(SecondDto dto) {
        SecondEntity domainObj = new SecondEntity(dto.getScore(), dto.getId() );
        SecondEntity savedEntity = repository.save(domainObj);
        LOG.log(Level.INFO, savedEntity.getId().toString());

    }

}
