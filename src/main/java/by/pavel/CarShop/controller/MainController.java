package by.pavel.CarShop.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/home")
	public String mainPage() {
		return "home";
	}
	
	@GetMapping("/soon")
	public String soon() {
		return "soon";
	}
	
	@GetMapping("/technology")
	public String technology() {
		return "technology";
	}
	
	@GetMapping("/contacts")
	public String contacts() {
		return "contacts";
	}
	
	@GetMapping("/pricing")
	public String pricing() {
		return "pricing";
	}
}
