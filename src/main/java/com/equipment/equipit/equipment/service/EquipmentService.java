package com.equipment.equipit.equipment.service;

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
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(ModelMapper modelMapper, EquipmentRepository equipmentRepository) {
        this.modelMapper = modelMapper;
        this.equipmentRepository = equipmentRepository;
    }


    public Page<EquipmentDTO> findAll(Boolean stock, Pageable pageable) {

        final Page<EquipmentEntity> results = stock != null && stock ? equipmentRepository.findAllEquipmentFromStock(pageable) : equipmentRepository.findAll(pageable);
        return results.map(entity -> modelMapper.map(entity, EquipmentDTO.class));
    }

    public EquipmentDTO getEquipment(String qrCode) {
        final EquipmentEntity equipmentEntity = equipmentRepository.findByQrCode(qrCode);
        return modelMapper.map(equipmentEntity, EquipmentDTO.class);
    }

    public void addEquipment(EquipmentDTO equipmentDTO) {

        final EquipmentEntity entity = modelMapper.map(equipmentDTO, EquipmentEntity.class);
        equipmentRepository.save(entity);
    }
}
