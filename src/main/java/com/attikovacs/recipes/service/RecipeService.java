package com.attikovacs.recipes.service;

import java.util.Set;

import com.attikovacs.recipes.model.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
	
	Recipe findById(Long id);

}
