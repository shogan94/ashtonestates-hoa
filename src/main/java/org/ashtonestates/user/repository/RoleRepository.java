package org.ashtonestates.user.repository;

import org.ashtonestates.user.model.Role;
import org.ashtonestates.user.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findById(int id);

	Role findByType(RoleType type);

}
