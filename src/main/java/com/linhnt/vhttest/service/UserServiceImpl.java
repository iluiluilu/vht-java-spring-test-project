package com.linhnt.vhttest.service;

import com.linhnt.vhttest.entity.UserEntity;
import com.linhnt.vhttest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "userCache", key = "#id")
    @Override
    public UserEntity getUserByIdWithCache(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
