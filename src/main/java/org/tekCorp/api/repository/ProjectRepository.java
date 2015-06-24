package org.tekCorp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tekCorp.api.domain.Project;

import java.util.List;

/**
 * Created by Inspiron on 15/06/2015.
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    /**
     * @param status the Project's status
     * @return the list of Project having the passed status or null if no Project is found
     */
    List<Project> findByStatus(String status);

    /**
     *
     * @param archived the Project's status of archiving
     * @return the list of Project having the passed archived status or null if no Project is found
     */
    List<Project> findByArchived(Boolean archived);

    List<Project> findByIdProjectIn(List<Integer> idProjectList);
}
