package com.tushar.userservice;

import com.tushar.userservice.domain.Role;
import com.tushar.userservice.domain.User;
import com.tushar.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.AbstractList;
import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));


			userService.saveUser(new User(null, "Touhidur Rahman", "tushar","tushar",  new ArrayList<>()));
			userService.saveUser(new User(null, "Toukir Rahman", "bijay","tushar",  new ArrayList<>()));
			userService.saveUser(new User(null, "Dilruba Khatun", "ruby","tushar",  new ArrayList<>()));
			userService.saveUser(new User(null, "Tahqiq prottoy", "tahqiq","tushar",  new ArrayList<>()));

			userService.addRoleToUser("tushar", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("tushar", "ROLE_ADMIN");
			userService.addRoleToUser("tushar", "ROLE_MANAGER");
			userService.addRoleToUser("bijay", "ROLE_ADMIN");
			userService.addRoleToUser("bijay", "ROLE_MANAGER");
			userService.addRoleToUser("ruby", "ROLE_MANAGER");
			userService.addRoleToUser("tahqiq", "ROLE_USER");
		};
	}
}