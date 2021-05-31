package by.pavel.CarShop.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import by.pavel.CarShop.models.Role;
import by.pavel.CarShop.models.User;
import by.pavel.CarShop.repos.UserRepository;

@Controller
public class RegistrationController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String addUser(User user, Map<String, Object> model) {
		User userFromDb = userRepository.findByUsername(user.getUsername());
		if(userFromDb != null) {
			model.put("message", "User exists!");
			return "registration";
		}
		user.setActive(true);
		user.setRoles(Collections.singleton(Role.USER));
		userRepository.save(user);
		return "redirect:login";
		}
	}
