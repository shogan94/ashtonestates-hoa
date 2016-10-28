package org.ashtonestates.model;

import javax.annotation.PostConstruct;
import javax.persistence.PrePersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DatabaseListener {

	static private BCryptPasswordEncoder passwordEncoder;

	@Autowired(required = true)
	@Qualifier("passwordEncoder")
	public void setPasswordEncoder(final BCryptPasswordEncoder passwordEncoder) {
		DatabaseListener.passwordEncoder = passwordEncoder;
	}

	@PostConstruct
	public void init() {
		log.debug("******* Initializing passwordEncoder for Listener [{}]", passwordEncoder);
	}

	@PrePersist
	public void hashPassword(final Object obj) {
		if (!(obj instanceof User)) {
			return;
		}

		final User user = (User) obj;
		final String pass = user.getPassword();
		final String encoded = passwordEncoder.encode(pass);
		user.setPassword(encoded);
	}
}