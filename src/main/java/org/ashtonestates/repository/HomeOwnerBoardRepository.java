/*
 *
 */
package org.ashtonestates.repository;

import org.ashtonestates.model.HomeOwnerBoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface HomeOwnerBoardRepository extends JpaRepository<HomeOwnerBoardMember, Long> {
	public HomeOwnerBoardMember findByEmail(String email);
}