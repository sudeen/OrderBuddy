package com.sudin;

import com.sudin.Entity.UserEntity.User;
import com.sudin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuddyApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BuddyApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User user=new User();
		user.setEmail("ranjitkarsudeen14@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Sudin");
		user.setLastName("Ranjitkar");
		user.setPassword("12345");
		user.setPhoneNumber("9849431839");
		user.setUserName("skiips");

		userService.createUser(user);
	}
}
