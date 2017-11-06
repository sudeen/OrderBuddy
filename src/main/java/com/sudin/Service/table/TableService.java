package com.sudin.Service.table;

import com.sudin.Entity.Tables;

import java.util.List;

public interface TableService {
    List<Tables> findAll();

    Tables findById(Long id);

    Tables save(Tables tables);

    void remove(Long id);
}
