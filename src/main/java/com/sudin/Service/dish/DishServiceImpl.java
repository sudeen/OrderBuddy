package com.sudin.Service.dish;

import com.sudin.Entity.Dish;
import com.sudin.Repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> findAll() {
        return (List<Dish>) dishRepository.findAll();
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findOne(id);
    }

    @Override
    public Dish save(Dish category) {
        return dishRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        dishRepository.delete(id);
    }

}
