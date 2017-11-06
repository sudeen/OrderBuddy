package com.sudin.Repository;

import com.sudin.Entity.Tables;
import org.springframework.data.repository.CrudRepository;

public interface TableRepository extends CrudRepository<Tables, Long> {
}
