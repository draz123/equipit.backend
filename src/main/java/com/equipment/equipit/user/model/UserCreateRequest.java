package com.equipment.equipit.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    private String email;
    private String password;
    private UUID teamId;
    private String position;

}
