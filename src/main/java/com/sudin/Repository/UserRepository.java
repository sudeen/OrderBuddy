package com.sudin.Repository;

import com.sudin.Entity.UserEntity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {
}
