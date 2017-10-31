package com.sudin.Entity.RestaurantEntity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String openingTime;
    private String closingTime;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private List<TableDesk> tablesList;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private List<Offer> offerList;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "restaurant")
    @JoinColumn(name = "contact_id")
    private Contact contactList;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private Additional additionalList;

    @Transient
    private MultipartFile restaurantImage;

    public Restaurant() {
    }

    public Restaurant(String name, String openingTime, String closingTime) {
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public Restaurant(String name, String openingTime, String closingTime, List<TableDesk> tablesList, List<Offer> offerList, Contact contactList, Additional additionalList) {
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.tablesList = tablesList;
        this.offerList = offerList;
        this.contactList = contactList;
        this.additionalList = additionalList;
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
