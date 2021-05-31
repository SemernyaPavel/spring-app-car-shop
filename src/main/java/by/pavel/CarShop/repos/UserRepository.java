package by.pavel.CarShop.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import by.pavel.CarShop.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
