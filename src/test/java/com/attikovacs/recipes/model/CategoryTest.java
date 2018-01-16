package com.attikovacs.recipes.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.attikovacs.recipes.model.Category;


public class CategoryTest {

	Category category;
	
	@Before
	public void setUp() throws Exception {
		category = new Category();
	}
	
	@Test
	public void testGetId() {
		Long id = 4L;
		category.setId(id);
		assertEquals(id, category.getId());
	}

	@Test
	public void testGetDescription() {
		String desc = "Desc";
		category.setDescription(desc);
		assertEquals(desc, category.getDescription());
	}

}
