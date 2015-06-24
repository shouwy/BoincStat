package org.tekCorp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tekCorp.api.domain.characteristic.Characteristic;
import org.tekCorp.api.domain.characteristic.CharacteristicKey;

import java.util.List;

/**
 * Created by Inspiron on 15/06/2015.
 */
public interface CharacteristicRepository extends JpaRepository<Characteristic, CharacteristicKey>{

    List<Characteristic> findByIdComputerId(Integer computerId);
}
