package com.attikovacs.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attikovacs.recipes.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RecipeController {

	private final RecipeService recipeService;

	@Autowired
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping(value = { "/recipe/show/{id}" })
	public String getRecipe(@PathVariable String id, Model model) {
		log.debug("Showing recipe - id: " + id);
		model.addAttribute("recipe", recipeService.findById(new Long(id)));
		
		return "recipe/show";
	}

}
