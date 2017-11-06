package com.sudin.Service.menu;

import com.sudin.Entity.Menus;
import com.sudin.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menurepository;

    @Override
    public List<Menus> findAll() {
        return (List<Menus>) menurepository.findAll();
    }

    @Override
    public Menus findById(Long id) {
        return menurepository.findOne(id);
    }

    @Override
    public Menus save(Menus category) {
        return menurepository.save(category);
    }

    @Override
    public void remove(Long id) {
        menurepository.delete(id);
    }

}
