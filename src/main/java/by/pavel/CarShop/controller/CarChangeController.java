package by.pavel.CarShop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.pavel.CarShop.models.Car;
import by.pavel.CarShop.repos.CarRepository;

@Controller
@RequestMapping("/catalog")
public class CarChangeController {
	
	@Autowired
	private CarRepository carRepository;
	
	
	@GetMapping("/{id}")
	public String showOneCar(@PathVariable("id") Long id, Model model) {
		
		Optional<Car> car = carRepository.findById(id);

		
		model.addAttribute("car", car);
		
		return "oneCar";
	}
	
	@PostMapping("/{id}")
	public String deleteCar(@PathVariable("id") Long id) {
		
		carRepository.deleteById(id);
		
		return "redirect:/catalog";
	}
	
	@GetMapping("/{id}/edit")
	public String editCar(Model model, @PathVariable("id") Long id) {
		
		Optional<Car> car = carRepository.findById(id);

		model.addAttribute("car", car);
		
		return "edit";
	}
	
	@PatchMapping("/{id}/edit")
	public String updateCar(@RequestParam String carModel,
							@RequestParam int cost,
							@RequestParam int maxSpeed,
							@RequestParam String description,
							@PathVariable("id") Long id) {
		
		Optional<Car> car = carRepository.findById(id);
		car.get().setCarModel(carModel);
		car.get().setCost(cost);
		car.get().setDescription(description);
		car.get().setMaxSpeed(maxSpeed);
		
		return "redirect:/catalog/{id}";
	}
}
