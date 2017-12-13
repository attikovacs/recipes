package com.attikovacs.recipes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.attikovacs.recipes.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	public Optional<Category> findByDescription(String description);

}
