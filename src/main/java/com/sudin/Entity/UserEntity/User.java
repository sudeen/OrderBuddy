package com.sudin.Entity.UserEntity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false,updatable = false)
    private Long id;

    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    @Column(name="email",nullable = false,updatable = false)
    private String email;
    private String phoneNumber;
    private boolean enabled = true;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<UserPayment> userPaymentList;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    @Transient
    private MultipartFile userImage;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<UserPayment> getUserPaymentList() {
        return userPaymentList;
    }

    public void setUserPaymentList(List<UserPayment> userPaymentList) {
        this.userPaymentList = userPaymentList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public MultipartFile getUserImage() {
        return userImage;
    }

    public void setUserImage(MultipartFile userImage) {
        this.userImage = userImage;
    }
}
