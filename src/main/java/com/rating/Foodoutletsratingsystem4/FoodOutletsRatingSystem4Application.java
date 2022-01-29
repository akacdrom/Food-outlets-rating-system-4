package com.rating.Foodoutletsratingsystem4;

import com.rating.Foodoutletsratingsystem4.entity.Restaurant;
import com.rating.Foodoutletsratingsystem4.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class FoodOutletsRatingSystem4Application{

	public static void main(String[] args) {
		SpringApplication.run(FoodOutletsRatingSystem4Application.class, args);
	}

//	@Autowired
//	private RestaurantRepository restaurantRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Restaurant restaurant = new Restaurant("xxx","xxx","xxx","xxxx","xxxx");
//		restaurantRepository.save(restaurant);
//	}
}
