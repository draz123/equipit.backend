package com.equipment.equipit.equipment.model;

import com.equipment.equipit.user.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "equipment_ownership")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equipment_ownership")
public class EquipmentOwnershipEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private EquipmentEntity equipment;
    private LocalDateTime assignmentTimestamp;
    private LocalDateTime dismissionTimestamp;
}
