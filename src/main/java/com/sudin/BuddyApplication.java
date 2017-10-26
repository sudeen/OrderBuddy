package com.sudin;

import com.sudin.Entity.RestaurantEntity.Restaurant;
import com.sudin.Entity.UserEntity.Users;
import com.sudin.Service.RestaurantService;
import com.sudin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuddyApplication implements CommandLineRunner {


    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    public static void main(String[] args) {
        SpringApplication.run(BuddyApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Users users = new Users();
        users.setEmail("ranjitkarsudeen14@gmail.com");
        users.setEnabled(true);
        users.setFirstName("Sudin");
        users.setLastName("Ranjitkar");
        users.setPassword("12345");
        users.setPhoneNumber("9849431839");
        users.setUserName("skiips");

        Restaurant restaurant = new Restaurant();
        restaurant.setName("Order Buddy");
        restaurant.setOpeningTime("10:00 AM");
        restaurant.setClosingTime("8:00 PM");
        userService.createUser(users);
        restaurantService.createRestaurant(restaurant);
    }
}
