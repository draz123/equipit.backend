package com.equipment.equipit.equipment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {

    private UUID id;
    private String serialNumber;
    private String model;
    private String equipmentGroupId;
    private String checklistJamcloudEnrollment;
    private String checklistConfirmationOfReceipt;
    private LocalDateTime purchaseTimestamp;
    private String qrCode;
    private String invoice;
    private double price;
    private EquipmentOwnershipDTO equipmentOwnershipDTO;
}
