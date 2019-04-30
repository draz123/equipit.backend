package com.equipment.equipit.equipment.db;

import com.equipment.equipit.equipment.model.EquipmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentRepository extends PagingAndSortingRepository<EquipmentEntity, UUID> {

    EquipmentEntity findByQrCode(String qrCode);

    @Query("select e from EquipmentEntity e left join e.equipmentOwnerships as eo where (eo.dismissionTimestamp is not null) or (eo.id is null)")
    Page<EquipmentEntity> findAllEquipmentFromStock(Pageable pageable);
}
