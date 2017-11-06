package com.sudin.Service.variants;

import com.sudin.Entity.Variants;

import java.util.List;

public interface VariantService {

    List<Variants> findAll();

    Variants findById(Long id);

    Variants save(Variants contact);

    void remove(Long id);
}
