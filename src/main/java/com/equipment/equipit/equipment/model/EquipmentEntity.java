package com.equipment.equipit.equipment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EquipmentEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String serialNumber;
    @ManyToOne
    private EquipmentGroupEntity equipmentGroupEntity;
    private String model;
    private String checklistJamcloudEnrollment;
    private String checklistConfirmationOfReceipt;
    private LocalDateTime purchaseTimestamp;
    private String qrCode;
    private String invoice;
    private double price;

    @ManyToOne
    private EquipmentOwnershipEntity equipmentOwnershipEntity;

}