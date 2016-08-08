package org.ashtonestates.security;

import org.ashtonestates.user.model.Role;
import org.ashtonestates.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IdToRoleConverter implements Converter<Object, Role> {

	@Autowired
	RoleRepository roleRepo;

	/*
	 * Gets UserProfile by Id
	 *
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang. Object)
	 */
	@Override
	public Role convert(final Object element) {
		final Integer id = Integer.parseInt((String) element);
		final Role profile = roleRepo.findById(id);
		return profile;
	}

	/*
	 * Gets UserProfile by type
	 *
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang. Object)
	 */
	/*
	 * public UserProfile convert(Object element) { String type = (String)element; UserProfile profile= userProfileService.findByType(type); System.out.println("Profile ... : "
	 * +profile); return profile; }
	 */

}