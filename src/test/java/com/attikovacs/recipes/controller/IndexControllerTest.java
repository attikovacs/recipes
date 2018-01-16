package com.attikovacs.recipes.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.attikovacs.recipes.model.Recipe;
import com.attikovacs.recipes.service.RecipeService;

public class IndexControllerTest {

	IndexController indexController;

	@Mock
	RecipeService recipeService;

	@Mock
	Model model;

	@Captor
	ArgumentCaptor<Set<Recipe>> captor;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeService);
	}

	@Test
	public void testGetIndex() {

		// given
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		Recipe recipe = new Recipe();
		recipe.setId(4L);
		recipes.add(recipe);

		when(recipeService.getRecipes()).thenReturn(recipes);

		// when
		String view = indexController.getIndex(model);

		// then
		assertEquals("index", view);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), captor.capture());
		assertEquals(2, captor.getValue().size());
	}

}
