package org.tekCorp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tekCorp.api.domain.User;

/**
 * Created by Inspiron on 15/06/2015.
 */
public interface UserRepository extends JpaRepository<User, String> {
}
