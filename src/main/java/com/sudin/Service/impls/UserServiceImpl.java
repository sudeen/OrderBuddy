package com.sudin.Service.impls;

import com.sudin.Entity.UserEntity.User;
import com.sudin.Repository.UserRepository;
import com.sudin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
