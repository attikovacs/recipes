package com.attikovacs.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attikovacs.recipes.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	private final RecipeService recipeService;

	@Autowired
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping(value = { "", "/" })
	public String getIndex(Model model) {
		log.debug("index.html");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}

}
