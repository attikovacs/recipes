package com.attikovacs.recipes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.attikovacs.recipes.model.UnitOfMeasure;

public interface UnitOfMeasuresRepository extends CrudRepository<UnitOfMeasure, Long> {
	
	public Optional<UnitOfMeasure> findByDescription(String description);

}
