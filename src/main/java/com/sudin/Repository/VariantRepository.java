package com.sudin.Repository;

import com.sudin.Entity.Contact;
import com.sudin.Entity.Variants;
import org.springframework.data.repository.CrudRepository;

public interface VariantRepository extends CrudRepository<Variants, Long> {
}
