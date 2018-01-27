package com.integration.one.repository;

import com.integration.one.domain.FirstEntity;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Maciej Lesniak
 */
public interface FirstEntityRepository extends CrudRepository<FirstEntity, Long>{

}
