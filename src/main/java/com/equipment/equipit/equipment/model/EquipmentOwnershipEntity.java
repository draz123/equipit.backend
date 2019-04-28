package com.equipment.equipit.equipment.model;

import com.equipment.equipit.user.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentOwnershipEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @OneToOne
    private UserEntity userEntity;
    @OneToMany
    private List<EquipmentEntity> equipmentEntity;
    private LocalDateTime assignmentTimestamp;
    private LocalDateTime dismissionTimestamp;
}
