package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String index(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		return "index";
	}
	
	@GetMapping("/pizza/create")
	public String createPizza(Model model) {
		
		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);
		
		return "pizza-create";
	}
	
	@PostMapping("/pizza/create")
	public String storePizza(@Valid @ModelAttribute("pizza") Pizza pizza) {
		
		pizzaService.save(pizza);
		return "redirect:/";
	}
	
	@GetMapping("/pizza/edit/{id}")
	public String editPizza(@PathVariable("id") int id, Model model) {
		
		Optional<Pizza> optPizza = pizzaService.getPizzaById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "pizza-edit";
	}
	
	@PostMapping("/pizza/edit")
	public String updatePizza(@Valid @ModelAttribute("pizza") Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) {
		
		pizzaService.deletePizzaById(id);
		
		return "redirect:/";
	}
}
