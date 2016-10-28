package org.ashtonestates.security;

import java.util.ArrayList;
import java.util.List;

import org.ashtonestates.model.State;
import org.ashtonestates.model.User;
import org.ashtonestates.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		final User user = userRepo.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("User email not found");
		}

		final org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.getState().equals(State.APPROVED), true, true, true, getGrantedAuthorities(user));

		return securityUser;
	}

	private List<GrantedAuthority> getGrantedAuthorities(final User user) {
		final List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().toString()));
		return authorities;
	}

}