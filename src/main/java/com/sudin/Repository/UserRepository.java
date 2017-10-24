package com.sudin.Repository;

import com.sudin.Entity.UserEntity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
