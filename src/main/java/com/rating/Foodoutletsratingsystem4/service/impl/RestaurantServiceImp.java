package com.rating.Foodoutletsratingsystem4.service.impl;

import com.rating.Foodoutletsratingsystem4.entity.Restaurant;
import com.rating.Foodoutletsratingsystem4.repository.RestaurantRepository;
import com.rating.Foodoutletsratingsystem4.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImp implements RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantServiceImp(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantByid(Long id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurantByid(Long id) {
        restaurantRepository.deleteById(id);
    }
}
