package by.pavel.CarShop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;


@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String description;
	private String carModel;
	private int maxSpeed;
	private int cost;

	public Car() {	}
	
	public Car(String carModel, int cost, int maxSpeed, String description) {
		this.carModel = carModel;
		this.cost = cost;
		this.maxSpeed = maxSpeed;
		this.description = description;
	}
	
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String name) {
		this.carModel = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}