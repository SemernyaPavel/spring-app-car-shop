package by.pavel.CarShop.controller;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.pavel.CarShop.models.Car;
import by.pavel.CarShop.repos.CarRepository;


@Controller
@RequestMapping("/catalog")
public class CarsController {
	
	@Autowired
	private CarRepository carRepository;
	
	
	@GetMapping
	public String showCarCatalog(Map<String, Object> model) {
		
		Iterable<Car> cars = carRepository.findAll();
		
		
		model.put("cars", cars);
		
		return "catalog";
	}
	
	@GetMapping("/create")
	public String addNewCar(Map<String, Object> model) {
		
		Iterable<Car> cars = carRepository.findAll();
		model.put("cars", cars);
		
		return "newCar";
	}
	
	@PostMapping("/create")
	public String addCar(@RequestParam String carModel,
						@RequestParam int cost,
						@RequestParam int maxSpeed,
						@RequestParam String description, 
						Map<String, Object> model) {
		
		Car car = new Car(carModel, cost, maxSpeed, description);
		
		
		carRepository.save(car);
		
		return "redirect:/catalog";
	}
	
	@GetMapping("/{id}")
	public String showOneCar(@PathVariable("id") Long id, Model model) {
		
		Optional<Car> car = carRepository.findById(id);

		
		model.addAttribute("car", car);
		
		return "oneCar";
	}
	
	@PostMapping("/{id}")
	public String deleteCar(@RequestParam Long id) {
		
		carRepository.deleteById(id);
		
		return "redirect:catalog";
	}
	
	@PostMapping
	public String filter(@RequestParam String filter,
			Map<String, Object> model) {
		Iterable<Car> cars;
		
		if(filter != null && !filter.isEmpty()) {
			cars = carRepository.findByCarModel(filter);
		}else {
			cars = carRepository.findAll();
		}
		
		
		model.put("cars", cars);
		return "catalog";
	}
}
