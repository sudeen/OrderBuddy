package com.sudin.Entity.UserEntity;

import javax.persistence.*;

@Entity
public class DeliveryPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String location;
    private String wardNo;

    @OneToOne
    private Order order;

    public DeliveryPlace() {
    }

    public DeliveryPlace(String street, String location, String wardNo, Order order) {
        this.street = street;
        this.location = location;
        this.wardNo = wardNo;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
