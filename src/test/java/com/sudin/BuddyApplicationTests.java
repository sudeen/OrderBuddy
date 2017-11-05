package com.sudin;

import com.google.gson.Gson;
import com.sudin.Entity.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuddyApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void saveContact(){
		Restaurant restaurant=new Restaurant();
		restaurant.setName("Order Buddy");
		restaurant.setOpeningTime("10:00 AM");
		restaurant.setClosingTime("8:00 PM");
		System.out.println("restaurant " +new Gson().toJson(restaurant));

//		Contact contact = new Contact();
//		contact.setEmail("Sudeen@gmail.com");
//		contact.setLandlineNumber("01-23221");
//		contact.setLocation("Sitapaila");
//		contact.setMobileNumber("987667112");
////		contact.setRestaurant(restaurant);
//
//		System.out.println("contact " +new Gson().toJson(contact));
	}

}
