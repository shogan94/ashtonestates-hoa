/*
 *
 */
package org.ashtonestates.user.repository;

import java.util.List;

import org.ashtonestates.user.model.AshtonStatus;
import org.ashtonestates.user.model.Role;
import org.ashtonestates.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);

	public List<User> findByStatus(AshtonStatus status);

	public List<User> findByRole(Role role);

	public Long countByStatus(AshtonStatus status);
}