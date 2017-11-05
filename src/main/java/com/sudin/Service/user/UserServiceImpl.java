package com.sudin.Service.user;

import com.sudin.Entity.Users;
import com.sudin.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Users> findAll() {
        return (List<Users>) userRepository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void remove(Long id) {
        userRepository.delete(id);
    }
}
