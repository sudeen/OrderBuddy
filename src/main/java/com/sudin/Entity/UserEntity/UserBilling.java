package com.sudin.Entity.UserEntity;

import javax.persistence.*;

@Entity
public class UserBilling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userBillingName;
    private String userBillingStreet;
    private String userBillingLocation;


    @OneToOne(cascade = CascadeType.ALL)
    private UserPayment userPayment;

    public UserBilling() {
    }

    public UserBilling(String userBillingName, String userBillingStreet, String userBillingLocation, UserPayment userPayment) {
        this.userBillingName = userBillingName;
        this.userBillingStreet = userBillingStreet;
        this.userBillingLocation = userBillingLocation;
        this.userPayment = userPayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserBillingName() {
        return userBillingName;
    }

    public void setUserBillingName(String userBillingName) {
        this.userBillingName = userBillingName;
    }

    public String getUserBillingStreet() {
        return userBillingStreet;
    }

    public void setUserBillingStreet(String userBillingStreet) {
        this.userBillingStreet = userBillingStreet;
    }

    public String getUserBillingLocation() {
        return userBillingLocation;
    }

    public void setUserBillingLocation(String userBillingLocation) {
        this.userBillingLocation = userBillingLocation;
    }

    public UserPayment getUserPayment() {
        return userPayment;
    }

    public void setUserPayment(UserPayment userPayment) {
        this.userPayment = userPayment;
    }
}
