package com.sudin.Repository.UserRepository;

import com.sudin.Entity.UserEntity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {
}
