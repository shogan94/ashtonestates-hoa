/*
 *
 */
package org.ashtonestates.user.repository;

import org.ashtonestates.user.model.UpcomingEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UpcomingEventsRepository extends JpaRepository<UpcomingEvents, Long> {

}