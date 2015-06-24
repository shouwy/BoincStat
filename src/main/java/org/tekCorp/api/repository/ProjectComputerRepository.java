package org.tekCorp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tekCorp.api.domain.projectcomputer.ProjectComputer;
import org.tekCorp.api.domain.projectcomputer.ProjectComputerKey;

import java.util.List;

/**
 * Created by Inspiron on 16/06/2015.
 */
public interface ProjectComputerRepository extends JpaRepository<ProjectComputer, ProjectComputerKey>{

    List<ProjectComputer> findByIdProjectId(Integer projectId);
    List<ProjectComputer> findByIdComputerId(Integer computerId);
}
