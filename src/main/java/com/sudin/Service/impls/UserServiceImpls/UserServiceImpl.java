package com.sudin.Service.impls.UserServiceImpls;

import com.sudin.Entity.UserEntity.Users;
import com.sudin.Repository.UserRepository.UserRepository;
import com.sudin.Service.UserServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void createUser(Users users) {
        userRepository.save(users);
    }
}
