package by.pavel.CarShop.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import by.pavel.CarShop.models.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
	
	List<Car> findByCarModel(String carModel);
}
