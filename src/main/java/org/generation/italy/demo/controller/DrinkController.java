package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drink")
public class DrinkController {
	
	@Autowired
	private DrinkService dS;
	
	@GetMapping
	public String index(Model model) {
		
		List<Drink> drinks = dS.findAll();
		model.addAttribute("drinks", drinks);
		return "drink-index";
	}
}
