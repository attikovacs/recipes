package com.attikovacs.recipes.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attikovacs.recipes.model.Recipe;
import com.attikovacs.recipes.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		log.debug("Getting recipes from database");
		return set;
	}

	@Override
	public Recipe findById(Long id) {
		return null;
	}
	
}
