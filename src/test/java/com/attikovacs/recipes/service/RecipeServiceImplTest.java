package com.attikovacs.recipes.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.attikovacs.recipes.model.Recipe;
import com.attikovacs.recipes.repository.RecipeRepository;
import com.attikovacs.recipes.service.RecipeServiceImpl;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeServiceImpl;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeServiceImpl = new RecipeServiceImpl(recipeRepository); 
	}

	@Test
	public void testGetRecipes() {
		Recipe recipe = new Recipe();
		Set<Recipe> recipesData = new HashSet<>();
		recipesData.add(recipe);
		
		when(recipeServiceImpl.getRecipes()).thenReturn(recipesData);
		
		Set<Recipe> recipes = recipeServiceImpl.getRecipes();
		assertEquals(1, recipes.size());
		verify(recipeRepository, times(1)).findAll();
	}

}
