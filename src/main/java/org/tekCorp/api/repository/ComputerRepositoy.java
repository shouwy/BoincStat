package org.tekCorp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tekCorp.api.domain.Computer;

import java.util.List;

/**
 * Created by Inspiron on 15/06/2015.
 */
public interface ComputerRepositoy extends JpaRepository<Computer, Integer>{

    List<Computer> findByIdUser(Integer idUser);
    List<Computer> findByIdComputerIn(List<Integer> idComputerList);
}
