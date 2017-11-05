package com.sudin.Service.user;

import com.sudin.Entity.Users;

import java.util.List;

public interface UserService {
    List<Users> findAll();

    Users findById(Long id);

    Users save(Users contact);

    void remove(Long id);
}
