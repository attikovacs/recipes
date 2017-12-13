package com.attikovacs.recipes.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attikovacs.recipes.model.Recipe;
import com.attikovacs.recipes.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	@Autowired
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> set = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(set::add);
		return set;
	}
	
}
