package com.sudin.Entity.UserEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal GrandTotal;

    @OneToMany(mappedBy="shoppingCart", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cartItemList;

    @OneToOne(cascade = CascadeType.ALL)
    private Users users;

    public ShoppingCart() {
    }

    public ShoppingCart(BigDecimal grandTotal, List<CartItem> cartItemList, Users users) {
        GrandTotal = grandTotal;
        this.cartItemList = cartItemList;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getGrandTotal() {
        return GrandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        GrandTotal = grandTotal;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
