package org.ashtonestates.user.repository;

import org.ashtonestates.user.model.ResetRequest;
import org.ashtonestates.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ResetRequestRepository extends JpaRepository<ResetRequest, Long> {

	ResetRequest findByRequestId(String requestId);

	ResetRequest findByUser(User user);

}
