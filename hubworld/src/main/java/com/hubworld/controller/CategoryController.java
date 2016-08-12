package com.hubworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hubworld.model.Category;
import com.hubworld.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/categories")
	public String getCategory(Model model) {
		model.addAttribute("category",new Category());
		model.addAttribute("categoryList",this.categoryService.listCategory());
		return "category";		
	}
	
	@RequestMapping("/addCategory")
	public String addCategory(@ModelAttribute("category")Category category) {
		categoryService.addCategory(category);
		return "redirect:/categories";
	}

	
}
