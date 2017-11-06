package com.sudin.Service.variants;

import com.sudin.Entity.Variants;
import com.sudin.Repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VariantServiceImpl implements VariantService {

    @Autowired
    private VariantRepository variantRepository;

    @Override
    public List<Variants> findAll() {
        return (List<Variants>) variantRepository.findAll();
    }

    @Override
    public Variants findById(Long id) {
        return variantRepository.findOne(id);
    }

    @Override
    public Variants save(Variants category) {
        return variantRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        variantRepository.delete(id);
    }

}
