package com.sudin.Service.table;

import com.sudin.Entity.Tables;
import com.sudin.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TableServiceImpl implements TableService {

    @Autowired
    private TableRepository tableRepository;

    @Override
    public List<Tables> findAll() {
        return (List<Tables>) tableRepository.findAll();
    }

    @Override
    public Tables findById(Long id) {
        return tableRepository.findOne(id);
    }

    @Override
    public Tables save(Tables tables) {
        return tableRepository.save(tables);
    }

    @Override
    public void remove(Long id) {
        tableRepository.delete(id);
    }
}
