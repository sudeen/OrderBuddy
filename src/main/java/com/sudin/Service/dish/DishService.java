package com.sudin.Service.dish;

import com.sudin.Entity.Dish;

import java.util.List;

public interface DishService {

    List<Dish> findAll();

    Dish findById(Long id);

    Dish save(Dish contact);

    void remove(Long id);
}
