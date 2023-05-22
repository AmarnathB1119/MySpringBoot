package io.javapro.springbootstart.userRepository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javapro.springbootstart.userModel.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	
	
	

}
