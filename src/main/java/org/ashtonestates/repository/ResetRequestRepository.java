package org.ashtonestates.repository;

import org.ashtonestates.model.ResetRequest;
import org.ashtonestates.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ResetRequestRepository extends JpaRepository<ResetRequest, Long> {

	ResetRequest findByRequestId(String requestId);

	ResetRequest findByUser(User user);

}
