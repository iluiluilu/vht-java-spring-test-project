package com.linhnt.vhttest.controller;

import com.linhnt.vhttest.entity.UserEntity;
import com.linhnt.vhttest.service.FileService;
import com.linhnt.vhttest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @GetMapping("/users/{id}")
    public String test(@PathVariable Long id) {

        Long start = System.currentTimeMillis();
        userService.getUserById(id);
        Long end = System.currentTimeMillis();
        fileService.appendToFile(String.format("without-cache-%s.log", id), String.valueOf(end - start));
        return "ok";
    }

    @GetMapping("/cache-users/{id}")
    public String testCache(@PathVariable Long id) {
        Long start = System.currentTimeMillis();
        userService.getUserByIdWithCache(id);
        Long end = System.currentTimeMillis();
        fileService.appendToFile(String.format("with-cache-%s.log", id), String.valueOf(end - start));
        return "ok";
    }
}
