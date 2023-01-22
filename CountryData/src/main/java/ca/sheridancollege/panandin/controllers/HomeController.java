package ca.sheridancollege.panandin.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ca.sheridancollege.panandin.beans.Country;
import ca.sheridancollege.panandin.database.DatabaseAccess;

@Controller
public class HomeController {

	@Autowired
	DatabaseAccess da;
	
	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("country", new Country());
		model.addAttribute("countryList", da.getCountry());
		return "countryList";
	}
	
	@GetMapping("/countryDetails/{id}")
	public String countryDetails(Model model, @PathVariable Long id) {
		da.getCountryById(id);
		model.addAttribute("country", new Country());
		model.addAttribute("countryList", da.getCountryById(id));
		return "countryDetails";
	}
}
