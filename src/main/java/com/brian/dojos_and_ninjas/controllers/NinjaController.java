package com.brian.dojos_and_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brian.dojos_and_ninjas.models.Dojo;
import com.brian.dojos_and_ninjas.models.Ninja;
import com.brian.dojos_and_ninjas.services.DojoService;
import com.brian.dojos_and_ninjas.services.NinjaService;

@Controller
public class NinjaController {

//	@Autowired
//	private NinjaService ninjaServ;
	
	@Autowired 
	private DojoService dojoServ;
	
	@Autowired
	private NinjaService ninjaServ;

	@GetMapping("/")
	public String allDojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
		// Show all the dojos
		List<Dojo> allDaDojos = dojoServ.allDojos();
		// Send allDaDojos to jsp.page
		model.addAttribute("allDaDojos", allDaDojos);
		// Show all the ninjas
		List<Ninja> allDaNinjas = ninjaServ.allNinjas();
		// Send allDaNinjas to jsp.page
		model.addAttribute("allDaNinjas", allDaNinjas);
		return "index.jsp";
	}

	// Post Create Expense Method
	@PostMapping("/dojos")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			dojoServ.createDojo(dojo);
			return "redirect:/new/ninja"; //redirect has to go to a route
		}
	}
//
//	// Render edit page
//	@GetMapping("/edit/{id}")
//	public String edit(@Valid @PathVariable("id") Long id, Model model) {
//		// find expense with provided id
//		Ninja ninja = ninjaServ.findNinja(id);
//		// pass this expense to jsp page to display data using model.addAttribute
//		model.addAttribute("ninja", ninja);
//		return "edit.jsp";
//
//	}
//
//	// Method for edit
//	@PutMapping("/edit/{id}")
//	public String update(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
//		if (result.hasErrors()) {
//			return "edit.jsp";
//		} else {
//			// If there are no errors, update the object
//			ninjaServ.updateNinja(ninja);
//			return "redirect:/";
//		}
//	}
//	
//	//  Create ninja page 
//
		@GetMapping("/new/ninja")
		public String NewNinja(@ModelAttribute("ninja") Ninja ninja, Model model) { 

			// Show all the dojos
			List<Dojo> allDaDojos = dojoServ.allDojos();
			// Send allDaDojos to jsp.page
			model.addAttribute("allDaDojos", allDaDojos);
			
			// Show all the dojos
			List<Ninja> allDaNinjas = ninjaServ.allNinjas();
			// Send allDaLanguages to jsp.page
			model.addAttribute("allDaNinjas", allDaNinjas);
			
			return "show.jsp";

		}
		
		@PostMapping("/create/ninja")
		public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {//ensure ninja is in jsp
			if (result.hasErrors()) {
				List<Dojo> allDaDojos = dojoServ.allDojos(); //need to add all dojos when post
				model.addAttribute("allDaDojos", allDaDojos); 
				
				List<Ninja> allDaNinjas = ninjaServ.allNinjas();
				model.addAttribute("allDaNinjas", allDaNinjas); //need to add all dojos when post
				return "show.jsp";
				
				
			} else {
				ninjaServ.createNinja(ninja);
				Long ninjaDojo = ninja.getDojo().getId();
				return "redirect:/dojos/page/" + ninjaDojo;
				
			}
			
			
		}
		
		@GetMapping("/dojos/page/{id}")
		public String showDojo(@PathVariable("id") Long id, Model model) {
			 
			
			Dojo thisDojo = dojoServ.findDojo(id); //need to add all dojos when post
			model.addAttribute("thisDojo", thisDojo);
			
//			List<Ninja> allDaNinjas = ninjaServ.allNinjas();
//			model.addAttribute("allDaNinjas", allDaNinjas);
			return "dojopage.jsp";
			
		}
		
	
			
//		
//		// Method for delete
//		@DeleteMapping("/ninjas/{id}")
//		public String destroy(@PathVariable("id") Long id) {
//			ninjaServ.deleteNinja(id);
//			return "redirect:/";
//		}

}

