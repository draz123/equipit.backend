package com.equipment.equipit.equipment.controller;

import com.equipment.equipit.equipment.model.EquipmentDTO;
import com.equipment.equipit.equipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipments")
    public Page<EquipmentDTO> findAll(@RequestParam("stock") Boolean stock, Pageable pageable) {
        return equipmentService.findAll(stock, pageable);
    }


    @PostMapping("/equipments")
    public ResponseEntity addEquipment(EquipmentDTO equipmentDTO) {
        equipmentService.addEquipment(equipmentDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/equipment")
    public EquipmentDTO addEquipment(@RequestParam("qrCode") String qrCode) {
        return equipmentService.getEquipment(qrCode);
    }
}
