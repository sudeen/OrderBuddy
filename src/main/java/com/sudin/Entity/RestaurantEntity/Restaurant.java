package com.sudin.Entity.RestaurantEntity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String openingTime;
    private String closingTime;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TableDesk> tablesList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Offer> offerList;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private Contact contactList;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private Additional additionalList;

    @Transient
    private MultipartFile restaurantImage;

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

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public List<TableDesk> getTablesList() {
        return tablesList;
    }

    public void setTablesList(List<TableDesk> tablesList) {
        this.tablesList = tablesList;
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
    }

    public Contact getContactList() {
        return contactList;
    }

    public void setContactList(Contact contactList) {
        this.contactList = contactList;
    }

    public Additional getAdditionalList() {
        return additionalList;
    }

    public void setAdditionalList(Additional additionalList) {
        this.additionalList = additionalList;
    }

    public MultipartFile getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(MultipartFile restaurantImage) {
        this.restaurantImage = restaurantImage;
    }
}
