package com.linhnt.vhttest.repository;

import com.linhnt.vhttest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
