package com.equipment.equipit.equipment.controller;

import com.equipment.equipit.equipment.model.EquipmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public Page<EquipmentDTO> findAll(Pageable pageable) {
        return equipmentService.findAll(pageable);

    }
}
