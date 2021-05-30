package by.pavel.CarShop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String carModel;
	private int maxSpeed;
	private String img;

	public Car() {	}
	
	public Car(String carModel, int maxSpeed , String img) {
		this.carModel = carModel;
		this.maxSpeed = maxSpeed;
		this.img = img;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}