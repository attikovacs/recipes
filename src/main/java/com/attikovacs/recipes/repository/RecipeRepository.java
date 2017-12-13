package com.attikovacs.recipes.repository;

import org.springframework.data.repository.CrudRepository;

import com.attikovacs.recipes.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
