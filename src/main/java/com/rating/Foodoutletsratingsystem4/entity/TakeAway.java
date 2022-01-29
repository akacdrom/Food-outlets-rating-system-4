package com.rating.Foodoutletsratingsystem4.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "et_take_away")
@Table(name = "et_take_away")
public class TakeAway extends Outlet{
    public TakeAway() {
    }

    public TakeAway(String name, String rating, String range, String hours, String city, String given_vote, String current_vote) {
        super(name, rating, range, hours, city, given_vote, current_vote);
    }
}
