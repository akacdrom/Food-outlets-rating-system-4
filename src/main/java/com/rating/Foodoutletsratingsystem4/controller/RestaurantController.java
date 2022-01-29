package com.rating.Foodoutletsratingsystem4.controller;

import com.rating.Foodoutletsratingsystem4.entity.Restaurant;
import com.rating.Foodoutletsratingsystem4.service.BistroService;
import com.rating.Foodoutletsratingsystem4.service.RestaurantService;
import com.rating.Foodoutletsratingsystem4.service.TakeAwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    private BistroService bistroService;
    private TakeAwayService takeAwayService;

    public RestaurantController(RestaurantService restaurantService, BistroService bistroService, TakeAwayService takeAwayService) {
        super();
        this.restaurantService = restaurantService;
        this.bistroService = bistroService;
        this.takeAwayService = takeAwayService;
    }

    @GetMapping("/outlets")
    public String listOutlets(Model model){
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        model.addAttribute("bistros", bistroService.getAllBistros());
        model.addAttribute("takeaways",takeAwayService.getAllTakeAway());
        return "outlets";
    }

    @GetMapping("/outlets/new-restaurant")
    public String createRestaurantForm(Model model){
        Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurant",restaurant);
        return "new-restaurant";
    }

    @PostMapping("/outlets")
    public String saveRestaurant(@ModelAttribute("outlet") Restaurant restaurant){
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/outlets";
    }

    @GetMapping("/outlets/edit/{id}")
    public String editRestaurant(@PathVariable Long id, Model model){
        model.addAttribute("restaurant",restaurantService.getRestaurantByid(id));
        return "edit-restaurant";
    }

    @PostMapping("/outlets/{id}")
    public String updateRestaurant(@PathVariable Long id, @ModelAttribute("restaurant") Restaurant restaurant, Model model){
        Restaurant existRestaurant = restaurantService.getRestaurantByid(id);
        existRestaurant.setId(id);
        existRestaurant.setName(restaurant.getName());
        try {
            String [] splitRating = existRestaurant.getGiven_vote().split("-");
            double sumOfRatings = 0;
            try {
                for (String s : splitRating) {
                    sumOfRatings += Double.parseDouble(s);
                }
                if (Integer.parseInt(restaurant.getCurrent_vote()) >= 0 ) {
                    double rating = (sumOfRatings+Double.parseDouble(restaurant.getCurrent_vote()))/(splitRating.length+1);
                    String calculatedRating = String.format("%.2f",rating);
                    existRestaurant.setRating(calculatedRating);
                    existRestaurant.setRange(restaurant.getRange());
                    existRestaurant.setHours(restaurant.getHours());
                    existRestaurant.setCity(restaurant.getCity());
                    existRestaurant.setGiven_vote(restaurant.getGiven_vote()+"-"+restaurant.getCurrent_vote());
                    existRestaurant.setCurrent_vote(restaurant.getCurrent_vote());
                    restaurantService.updateRestaurant(existRestaurant);
                }
            }catch (Exception ex){
                existRestaurant.setGiven_vote(restaurant.getCurrent_vote());
                existRestaurant.setCurrent_vote(restaurant.getCurrent_vote());
                restaurantService.updateRestaurant(existRestaurant);
            }
        }catch (Exception e){
        }
        return "redirect:/outlets";
    }

    @GetMapping("/outlets/{id}")
    public String deleteRestaurant(@PathVariable Long id){
        restaurantService.deleteRestaurantByid(id);
        return "redirect:/outlets";
    }
}
