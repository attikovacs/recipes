package com.attikovacs.recipes.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.attikovacs.recipes.enums.Difficulty;
import com.attikovacs.recipes.model.Category;
import com.attikovacs.recipes.model.Ingredient;
import com.attikovacs.recipes.model.Notes;
import com.attikovacs.recipes.model.Recipe;
import com.attikovacs.recipes.model.UnitOfMeasure;
import com.attikovacs.recipes.repository.CategoryRepository;
import com.attikovacs.recipes.repository.RecipeRepository;
import com.attikovacs.recipes.repository.UnitOfMeasuresRepository;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasuresRepository unitOfMeasuresRepository;

	public RecipeBootstrap(CategoryRepository categoryRepository, UnitOfMeasuresRepository unitOfMeasuresRepository,
			RecipeRepository recipeRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasuresRepository = unitOfMeasuresRepository;
		this.recipeRepository = recipeRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		recipeRepository.saveAll(initRecipes());
	}

	private List<Recipe> initRecipes() {
		List<Recipe> recipes = new ArrayList<>(2);

		Recipe guac = new Recipe();
		guac.setCookTime(0);
		guac.setPrepTime(20);
		guac.setDescription("Avocado cream");
		guac.setDifficulty(Difficulty.EASY);
		guac.setDirections("1. cut the avocado.\n2. use a fork to make it creamy");

		Optional<UnitOfMeasure> uom1Opt = unitOfMeasuresRepository.findByDescription("Tablespoon");
		if (!uom1Opt.isPresent()) {
			throw new RuntimeException("Tablespoon does not exist");
		}
		UnitOfMeasure uom1 = uom1Opt.get();
		Ingredient ing1 = new Ingredient();
		ing1.setAmount(new BigDecimal(2));
		ing1.setDescription("salt");
		ing1.setUnitOfMeasure(uom1);
		ing1.setRecipe(guac);
		guac.getIngredients().add(ing1);
		Optional<UnitOfMeasure> uom2Opt = unitOfMeasuresRepository.findByDescription("Teaspoon");
		if (!uom2Opt.isPresent()) {
			throw new RuntimeException("Teaspoon does not exist");
		}
		UnitOfMeasure uom2 = uom2Opt.get();
		Ingredient ing2 = new Ingredient();
		ing2.setAmount(new BigDecimal(1));
		ing2.setDescription("pepper");
		ing2.setUnitOfMeasure(uom2);
		ing2.setRecipe(guac);
		guac.getIngredients().add(ing2);

		Notes notes = new Notes();
		notes.setNotes("This is a good guacamole");
		notes.setRecipe(guac);
		guac.setNotes(notes);

		Category cat1 = categoryRepository.findByDescription("Soup").get();
		guac.getCategories().add(cat1);
		Category cat2 = categoryRepository.findByDescription("Vegan").get();
		guac.getCategories().add(cat2);

		guac.setServings(4);
		guac.setUrl("http://simplerecipes.com/guacamole");
		guac.setSource("source");

		recipes.add(guac);

		Recipe taco = new Recipe();
		taco.setCookTime(10);
		taco.setPrepTime(30);
		taco.setDescription("Taco");
		taco.setDifficulty(Difficulty.MODERATE);
		taco.setDirections("1. prepare the tacos");

		uom1 = unitOfMeasuresRepository.findByDescription("Cup").get();
		ing1 = new Ingredient();
		ing1.setAmount(new BigDecimal(2));
		ing1.setDescription("water");
		ing1.setUnitOfMeasure(uom1);
		ing1.setRecipe(taco);
		taco.getIngredients().add(ing1);
		uom2 = unitOfMeasuresRepository.findByDescription("Glass").get();
		ing2 = new Ingredient();
		ing2.setAmount(new BigDecimal(1));
		ing2.setDescription("milk");
		ing2.setUnitOfMeasure(uom2);
		ing2.setRecipe(taco);
		taco.getIngredients().add(ing2);

		notes = new Notes();
		notes.setNotes("This is a good taco");
		notes.setRecipe(taco);
		taco.setNotes(notes);

		cat1 = categoryRepository.findByDescription("Meat").get();
		taco.getCategories().add(cat1);

		taco.setServings(2);
		taco.setUrl("http://simplerecipes.com/taco");
		taco.setSource("sourcetaco");

		recipes.add(taco);

		return recipes;
	}

}
