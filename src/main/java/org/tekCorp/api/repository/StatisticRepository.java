package org.tekCorp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tekCorp.api.domain.Computer;
import org.tekCorp.api.domain.statistic.Statistic;
import org.tekCorp.api.domain.statistic.StatisticKey;

import java.util.List;

/**
 * Created by Inspiron on 16/06/2015.
 */
public interface StatisticRepository extends JpaRepository<Statistic, StatisticKey>{

    List<Statistic> findByIdProjectId(Integer projectId);
    List<Statistic> findByIdProjectIdIn(List<Integer> listProject);
    List<Statistic> findByIdComputerId(Integer computerId);
    List<Statistic> findByIdComputerIdIn(List<Integer> listComputer);
    List<Statistic> findByIdIn(List<StatisticKey> listIdKey);
    List<Statistic> findByIdProjectIdInAndIdComputerIdIn(List<Integer> listIdProject, List<Integer> listIdomputer);
}
