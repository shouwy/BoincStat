package org.tekCorp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tekCorp.api.domain.projectuser.ProjectUser;
import org.tekCorp.api.domain.projectuser.ProjectUserKey;

import java.util.List;

/**
 * Created by Inspiron on 16/06/2015.
 */
public interface ProjectUserRepository extends JpaRepository<ProjectUser, ProjectUserKey>{

    List<ProjectUser> findByIdProjectId(Integer projectId);
    List<ProjectUser> findByIdUserId(Integer userId);
}
