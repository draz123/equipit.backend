package com.equipment.equipit.equipment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "equipment")
public class EquipmentEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "equipment_group_id", nullable = false)
    private EquipmentGroupEntity equipmentGroupEntity;
    private String model;
    private String checklistJamcloudEnrollment;
    private String checklistConfirmationOfReceipt;
    private LocalDateTime purchaseTimestamp;
    private String qrCode;
    private String invoice;
    private double price;

    @OneToMany(mappedBy = "equipment", orphanRemoval = true)
    private List<EquipmentOwnershipEntity> equipmentOwnerships;

}