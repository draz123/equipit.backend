package com.equipment.equipit.user.controller;

import com.equipment.equipit.user.model.UserCreateRequest;
import com.equipment.equipit.user.model.UserDTO;
import com.equipment.equipit.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createAccount(@RequestBody UserCreateRequest userCreateRequest) {
        final UserDTO user = userService.createUser(userCreateRequest);
        return ResponseEntity.ok(user);
    }
}
