package com.sudin.Repository;

import com.sudin.Entity.Contact;
import com.sudin.Entity.Menus;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menus, Long> {
}
