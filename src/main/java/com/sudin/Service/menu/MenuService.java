package com.sudin.Service.menu;

import com.sudin.Entity.Menus;

import java.util.List;

public interface MenuService {

    List<Menus> findAll();

    Menus findById(Long id);

    Menus save(Menus contact);

    void remove(Long id);
}
