package com.rating.Foodoutletsratingsystem4.service;


import com.rating.Foodoutletsratingsystem4.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();

    Restaurant saveRestaurant(Restaurant restaurant);

    Restaurant getRestaurantByid(Long id);

    Restaurant updateRestaurant(Restaurant restaurant);

    void deleteRestaurantByid(Long id);

}
