package com.sudin.Entity.UserEntity;

import javax.persistence.*;

@Entity
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String variantType;
    private int price;

    @ManyToOne
    private Menu menu;

    public Variant() {
    }

    public Variant(String variantType, int price, Menu menu) {
        this.variantType = variantType;
        this.price = price;
        this.menu = menu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariantType() {
        return variantType;
    }

    public void setVariantType(String variantType) {
        this.variantType = variantType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
