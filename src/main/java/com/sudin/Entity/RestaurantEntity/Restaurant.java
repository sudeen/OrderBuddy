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

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contactList;

    @OneToOne(cascade = CascadeType.ALL)
    private Additional additionalList;

    @Transient
    private MultipartFile restaurantImage;



}
