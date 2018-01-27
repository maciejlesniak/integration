package com.integration.two.repository;

import com.integration.two.domain.SecondEntity;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Maciej Lesniak
 */
public interface SecondEntityRepository extends CrudRepository<SecondEntity, Long>{

}
