/*
 *
 */
package org.ashtonestates.repository;

import org.ashtonestates.model.UpcomingEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UpcomingEventsRepository extends JpaRepository<UpcomingEvents, Long> {

}