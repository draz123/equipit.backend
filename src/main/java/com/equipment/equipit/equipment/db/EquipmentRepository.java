package com.equipment.equipit.equipment.db;

import com.equipment.equipit.equipment.model.EquipmentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentRepository extends PagingAndSortingRepository<EquipmentEntity, UUID> {

}
