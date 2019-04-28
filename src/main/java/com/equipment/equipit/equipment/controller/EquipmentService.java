package com.equipment.equipit.equipment.controller;

import com.equipment.equipit.equipment.db.EquipmentRepository;
import com.equipment.equipit.equipment.model.EquipmentDTO;
import com.equipment.equipit.equipment.model.EquipmentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

    private final ModelMapper modelMapper;

    public EquipmentService(ModelMapper modelMapper, EquipmentRepository equipmentRepository) {
        this.modelMapper = modelMapper;
        this.equipmentRepository = equipmentRepository;
    }

    private final EquipmentRepository equipmentRepository;

    public Page<EquipmentDTO> findAll(Pageable pageable) {
        final Page<EquipmentEntity> results = equipmentRepository.findAll(pageable);
        return results.map(entity -> modelMapper.map(entity, EquipmentDTO.class));
    }
}
