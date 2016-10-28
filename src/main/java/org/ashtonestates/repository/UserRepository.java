/*
 *
 */
package org.ashtonestates.repository;

import java.util.List;

import org.ashtonestates.model.Role;
import org.ashtonestates.model.State;
import org.ashtonestates.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);

	public List<User> findByState(State state);

	public List<User> findByRole(Role role);

	public Long countByState(State state);
}