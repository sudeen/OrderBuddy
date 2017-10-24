package com.sudin.Entity.UserEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
/*use table entity as Order can be of inbuilt hibernate class*/
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date orderDate;
    private String orderStatus;
    private BigDecimal orderTotal;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<CartItem> cartItemList;

    @OneToOne(cascade = CascadeType.ALL)
    private DeliveryPlace shippingAddress;

//    @OneToOne(cascade = CascadeType.ALL)
//    private BillingAddress billingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    private User user;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public DeliveryPlace getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(DeliveryPlace shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
