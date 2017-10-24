package com.sudin.Entity.UserEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private boolean availability = true;

    @Column(columnDefinition = "text")
    private String description;

    @Transient
    private MultipartFile foodImage;

    private String ingredients;
    private String category;
    private String rating;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Variant> variantList;

    @OneToMany(mappedBy = "menu")
    @JsonIgnore
    private List<MenuToCartItem> menuToCartItemList;

    public Menu() {
    }

    public Menu(String name, boolean availability, String description, MultipartFile foodImage, String ingredients, String category, String rating, List<Variant> variantList, List<MenuToCartItem> menuToCartItemList) {
        this.name = name;
        this.availability = availability;
        this.description = description;
        this.foodImage = foodImage;
        this.ingredients = ingredients;
        this.category = category;
        this.rating = rating;
        this.variantList = variantList;
        this.menuToCartItemList = menuToCartItemList;
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

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(MultipartFile foodImage) {
        this.foodImage = foodImage;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<Variant> getVariantList() {
        return variantList;
    }

    public void setVariantList(List<Variant> variantList) {
        this.variantList = variantList;
    }

    public List<MenuToCartItem> getMenuToCartItemList() {
        return menuToCartItemList;
    }

    public void setMenuToCartItemList(List<MenuToCartItem> menuToCartItemList) {
        this.menuToCartItemList = menuToCartItemList;
    }
}
