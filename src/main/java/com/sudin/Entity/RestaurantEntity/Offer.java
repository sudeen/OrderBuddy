package com.sudin.Entity.RestaurantEntity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Transient
    private MultipartFile offerImage;

    @ManyToOne
    private Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(MultipartFile offerImage) {
        this.offerImage = offerImage;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
