package com.sudin.Entity.RestaurantEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Additional {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Restaurant restaurant;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PaymentRestaurant> paymentRestaurantList;

    private int deliveryCost;
    private int tax;
    private String ratings;
    private boolean parkingAvailability;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<PaymentRestaurant> getPaymentRestaurantList() {
        return paymentRestaurantList;
    }

    public void setPaymentRestaurantList(List<PaymentRestaurant> paymentRestaurantList) {
        this.paymentRestaurantList = paymentRestaurantList;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(int deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public boolean isParkingAvailability() {
        return parkingAvailability;
    }

    public void setParkingAvailability(boolean parkingAvailability) {
        this.parkingAvailability = parkingAvailability;
    }
}
