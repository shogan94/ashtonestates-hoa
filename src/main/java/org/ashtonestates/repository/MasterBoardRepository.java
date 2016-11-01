/*
 *
 */
package org.ashtonestates.repository;

import org.ashtonestates.model.MasterBoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MasterBoardRepository extends JpaRepository<MasterBoardMember, Long> {
	public MasterBoardMember findByEmail(String email);
}