package com.sudin.Service.category;

import com.sudin.Entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category save(Category contact);

    void remove(Long id);
}
