/*
 *
 */
package org.ashtonestates.repository;

import org.ashtonestates.model.TownhomeBoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TownhomeBoardRepository extends JpaRepository<TownhomeBoardMember, Long> {
	public TownhomeBoardMember findByEmail(String email);
}