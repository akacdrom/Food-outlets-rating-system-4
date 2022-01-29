package com.rating.Foodoutletsratingsystem4.entity;

import javax.persistence.*;

@MappedSuperclass
public class Outlet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private String rating;

    @Column(name = "range")
    private String range;

    @Column(name = "hours")
    private String hours;

    @Column(name = "city")
    private String city;

    @Column(name = "given_vote")
    private String given_vote;

    @Column(name = "current_vote")
    private String current_vote;

    public Outlet(){
        super();
    }

    public Outlet(String name, String rating, String range, String hours, String city, String given_vote, String current_vote) {
        this.name = name;
        this.rating = rating;
        this.range = range;
        this.hours = hours;
        this.city = city;
        this.given_vote = given_vote;
        this.current_vote = current_vote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGiven_vote() {
        return given_vote;
    }

    public void setGiven_vote(String given_vote) {
        this.given_vote = given_vote;
    }

    public String getCurrent_vote() {
        return current_vote;
    }

    public void setCurrent_vote(String current_vote) {
        this.current_vote = current_vote;
    }
}
