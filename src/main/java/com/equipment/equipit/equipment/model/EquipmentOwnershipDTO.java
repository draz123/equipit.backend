package com.equipment.equipit.equipment.model;

import com.equipment.equipit.user.model.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentOwnershipDTO {
    private UUID id;
    private UserDTO user;
    private LocalDateTime assignmentTimestamp;
    private LocalDateTime dismissionTimestamp;

}
