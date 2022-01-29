package com.rating.Foodoutletsratingsystem4.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "et_restaurant")
@Table(name = "et_restaurant")
public class Restaurant extends Outlet{
    public Restaurant() {
    }

    public Restaurant(String name, String rating, String range, String hours, String city, String given_vote, String current_vote) {
        super(name, rating, range, hours, city,given_vote,current_vote);
    }
}
