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
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public void remove(Long id) {
        dishRepository.delete(id);
    }

    @Override
    public Dish findByIdList(List<Long> dishId) {
        Dish dish= (Dish) dishRepository.findAll(dishId);
        return dish;
    }

}
