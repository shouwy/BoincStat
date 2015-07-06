package org.tekCorp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tekCorp.api.domain.User;

import java.util.List;

/**
 * Created by Inspiron on 15/06/2015.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByIdUserIn(List<Integer> listIdUser);
    User findByBoincId(String boincId);
}
