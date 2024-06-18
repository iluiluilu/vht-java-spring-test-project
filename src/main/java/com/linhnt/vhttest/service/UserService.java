package com.linhnt.vhttest.service;

import com.linhnt.vhttest.entity.UserEntity;

public interface UserService {

    UserEntity getUserByIdWithCache(Long id);

    UserEntity getUserById(Long id);
}
